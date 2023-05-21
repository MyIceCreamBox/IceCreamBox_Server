package com.example.myicecreambox.gift.dto;

import lombok.Getter;

@Getter
public class SendGiftReq {
  private String iceCreamImgKey;
  private String senderNickname;
  private String message;
}
