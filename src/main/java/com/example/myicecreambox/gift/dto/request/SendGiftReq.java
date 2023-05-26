package com.example.myicecreambox.gift.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SendGiftReq {
  private String iceCreamImgKey;
  private String senderNickname;
  private String message;

  @Builder
  public SendGiftReq(String iceCreamImgKey , String senderNickname, String message) {
    this.iceCreamImgKey = iceCreamImgKey;
    this.senderNickname = senderNickname;
    this.message = message;
  }

  public static SendGiftReq toDto(String iceCreamImgKey , String senderNickname, String message) {
    return SendGiftReq.builder()
            .iceCreamImgKey(iceCreamImgKey)
            .senderNickname(senderNickname)
            .message(message)
            .build();
  }

}
