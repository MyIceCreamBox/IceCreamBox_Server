package com.example.myicecreambox.user.dto.Response;

import com.example.myicecreambox.gift.entity.Gift;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceivedGiftRes {
  private Long giftIdx;
  private String message;
  private String iceCreamImgUrl;

  public static ReceivedGiftRes toDto(Gift gift) {
    ReceivedGiftRes receivedGiftRes = new ReceivedGiftRes();
    receivedGiftRes.giftIdx = gift.getGiftIdx();
    receivedGiftRes.message = gift.getMessage();
    // todo ImgKey -> ImgUrl 변경 로직 필요
    receivedGiftRes.iceCreamImgUrl = gift.getIceCreamImgKey();
    return receivedGiftRes;
  }
}


