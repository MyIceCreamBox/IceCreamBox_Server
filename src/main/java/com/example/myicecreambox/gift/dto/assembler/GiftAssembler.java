package com.example.myicecreambox.gift.dto.assembler;

import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.GiftsStatisticsRes;
import com.example.myicecreambox.gift.entity.Gift;
import com.example.myicecreambox.gift.entity.UserGift;
import com.example.myicecreambox.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GiftAssembler {
  public Gift toEntity(String message, String iceCreamImgKey) {
    return Gift.builder().message(message).iceCreamImgKey(iceCreamImgKey).build();
  }

  public List<UserGift> toUpdateAssociation(User sender, User receiver, Gift gift) {

    return null;
  }

  public void toUpdateGiftChance(User sender, User receiver) {
    sender.decreaseGiftChance(sender.getGiftChance());
    receiver.increaseGiftChance(receiver.getGiftChance());
  }

  public GiftsStatisticsRes toGiftStatisticsByIceCreamStatus(List<Gift> receivedGifts) {
    return null;
  }
}
