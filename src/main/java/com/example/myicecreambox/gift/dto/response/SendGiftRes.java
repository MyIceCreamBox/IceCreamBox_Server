package com.example.myicecreambox.gift.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendGiftRes {
  private String nickname;
  private String iceCreamImgUrl;
}
