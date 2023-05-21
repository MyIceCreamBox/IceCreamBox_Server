package com.example.myicecreambox.gift.controller;

import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.GetIceCreamRateRes;
import com.example.myicecreambox.gift.dto.response.SendGiftRes;
import com.example.myicecreambox.gift.service.GiftService;
import com.example.myicecreambox.global.dto.ResponseCustom;
import com.example.myicecreambox.global.resolver.Auth;
import com.example.myicecreambox.global.resolver.IsLogin;
import com.example.myicecreambox.global.resolver.LoginStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gifts")
@RequiredArgsConstructor
public class GiftController {

  private final GiftService giftService;

  @Auth
  @PostMapping("/send")
  public ResponseCustom<SendGiftRes> sendGift(@RequestBody SendGiftReq sendGiftReq,
                                              @IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.sendGift(sendGiftReq, loginStatus.getUserIdx()));
  }

  @Auth
  @GetMapping("/count")
  public ResponseCustom<Long> getMyGiftCount(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.getMyGiftCount(loginStatus.getUserIdx()));
  }

  @Auth
  @GetMapping("/rate/icecream")
  public ResponseCustom<GetIceCreamRateRes> getMyIceCreamRate(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.getMyIceCreamRate(loginStatus.getUserIdx()));
  }
}
