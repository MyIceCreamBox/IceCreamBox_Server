package com.example.myicecreambox.gift.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendGiftRes {
  private Long giftIdx;
//  private String nickname;
//  private String iceCreamImgUrl;

  @Builder
  public SendGiftRes( Long giftIdx) {
    this.giftIdx = giftIdx;
  }
  public static SendGiftRes toDto(Long userIdx) {
    return SendGiftRes.builder()
            .giftIdx(userIdx)
            .build();
  }
}
