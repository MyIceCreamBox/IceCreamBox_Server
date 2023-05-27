package com.example.myicecreambox.gift.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SendGiftReq {
  private String iceCreamImgKey;
  private String senderNickname;
  private String message;
}
