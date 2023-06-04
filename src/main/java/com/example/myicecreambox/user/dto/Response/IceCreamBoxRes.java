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
  private String nickname;
  private Boolean isAfter;

  public static IceCreamBoxRes toDto(List<Gift> receivedGifts, String nickname, Boolean isAfter) {
    IceCreamBoxRes iceCreamBoxRes = new IceCreamBoxRes();
    iceCreamBoxRes.myIceCreams = receivedGifts.stream().map(ReceivedGiftRes::toDto).collect(Collectors.toList());
    iceCreamBoxRes.nickname = nickname;
    iceCreamBoxRes.isAfter = isAfter;
    return iceCreamBoxRes;
  }
}
