package com.example.myicecreambox.gift.controller;

import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.GiftsStatisticsRes;
import com.example.myicecreambox.gift.service.GiftService;
import com.example.myicecreambox.global.dto.ResponseCustom;
import com.example.myicecreambox.global.resolver.Auth;
import com.example.myicecreambox.global.resolver.IsLogin;
import com.example.myicecreambox.global.resolver.LoginStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gifts")
@RequiredArgsConstructor
public class GiftController {

  private final GiftService giftService;

  @Auth
  @PostMapping("/send/{receiverIdx}")
  public ResponseCustom<Long> sendGift(@RequestBody SendGiftReq sendGiftReq,
                                              @PathVariable(name = "receiverIdx") Long receiverIdx,
                                              @IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.sendGift(sendGiftReq, loginStatus.getUserIdx(), receiverIdx)); //receiver 추가
  }

  @Auth
  @GetMapping("/count")
  public ResponseCustom<Integer> getMyGiftCount(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.getMyGiftCount(loginStatus.getUserIdx()));
  }

  @Auth
  @GetMapping("/statistics/gift-rate")
  public ResponseCustom<GiftsStatisticsRes> getMyGiftStatistics(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.getMyGiftStatistics(loginStatus.getUserIdx()));
  }

  @Auth
  @GetMapping("/chance")
  public ResponseCustom<Integer> getMyGiftChance(@IsLogin LoginStatus loginStatus) {
    return ResponseCustom.OK(giftService.getMyGiftChance(loginStatus.getUserIdx()));
  }
}
