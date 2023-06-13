package com.example.myicecreambox.user.controller;

import com.example.myicecreambox.global.dto.ResponseCustom;
import com.example.myicecreambox.global.resolver.Auth;
import com.example.myicecreambox.global.resolver.IsLogin;
import com.example.myicecreambox.global.resolver.LoginStatus;
import com.example.myicecreambox.user.dto.Request.*;
import com.example.myicecreambox.user.dto.Response.IceCreamBoxRes;
import com.example.myicecreambox.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @ResponseBody
  @PostMapping("/join")
  public ResponseCustom<?> join(@RequestBody PostUserReq postUserReq) {
    return ResponseCustom.OK(userService.join(postUserReq));
  }

  @ResponseBody
  @PostMapping("/login")
  public ResponseCustom<?> login(@RequestBody LoginUserReq loginUserReq) {
    return ResponseCustom.OK(userService.login(loginUserReq));
  }

  @Auth
  @PostMapping("/logout")
  public ResponseCustom<?> logout(@IsLogin LoginStatus loginStatus) {
    userService.logout(loginStatus.getUserIdx());
    return ResponseCustom.OK();
  }

  @Auth
  @DeleteMapping("/delete")
  public ResponseCustom<?> deleteUser(@IsLogin LoginStatus loginStatus) {
    userService.deleteUser(loginStatus.getUserIdx());
    return ResponseCustom.OK();
  }

  @ResponseBody
  @PostMapping("/nickname")
  public ResponseCustom<?> checkNickname(@RequestBody PostNicknameReq postNicknameReq) {
    return ResponseCustom.OK(userService.checkNickname(postNicknameReq));
  }

  @ResponseBody
  @PostMapping("/email")
  public ResponseCustom<?> checkEmail(@RequestBody PostEmailReq postEmailReq) {
    return ResponseCustom.OK(userService.checkEmail(postEmailReq));
  }

  @Auth
  @GetMapping("/my-page")
  public ResponseCustom<IceCreamBoxRes> getMyIceCreamBox(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(userService.getMyIceCreamBox(loginStatus.getUserIdx()));
  }

  @Auth
  @GetMapping("/share-link")
  public ResponseCustom<String> shareUserLink(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(userService.shareUserLink(loginStatus.getUserIdx()));
  }


  // test controller
  @ResponseBody
  @GetMapping("/test")
  public ResponseCustom<?> testController() {
    System.out.println("test");
    System.out.println("ci/cd test");
    System.out.println("ci/cd test2");
    System.out.println("ci/cd test3");
    System.out.println("ci/cd test4");
    return ResponseCustom.OK("test");
  }
}
