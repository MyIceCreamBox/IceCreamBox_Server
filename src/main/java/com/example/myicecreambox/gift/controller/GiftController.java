package com.example.myicecreambox.gift.controller;

import com.example.myicecreambox.gift.dto.SendGiftReq;
import com.example.myicecreambox.gift.dto.SendGiftRes;
import com.example.myicecreambox.gift.service.GiftService;
import com.example.myicecreambox.global.dto.ResponseCustom;
import com.example.myicecreambox.global.resolver.Auth;
import com.example.myicecreambox.global.resolver.IsLogin;
import com.example.myicecreambox.global.resolver.LoginStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
