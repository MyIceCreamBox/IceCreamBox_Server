package com.example.myicecreambox.user.dto.Response;

import com.example.myicecreambox.gift.entity.Gift;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class IceCreamBoxRes {
  private List<ReceivedGiftRes> myIceCreams;

  public static IceCreamBoxRes toDto(List<Gift> receivedGifts) {
    IceCreamBoxRes iceCreamBoxRes = new IceCreamBoxRes();
    iceCreamBoxRes.myIceCreams = receivedGifts.stream().map(ReceivedGiftRes::toDto).collect(Collectors.toList());
    return iceCreamBoxRes;
  }
}
