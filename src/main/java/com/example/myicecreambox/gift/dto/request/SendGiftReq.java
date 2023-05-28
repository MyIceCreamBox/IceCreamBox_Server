package com.example.myicecreambox.gift.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SendGiftReq {
  private String iceCreamName;
  private String senderNickname;
  private String message;
}
