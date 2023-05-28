package com.example.myicecreambox.gift.dto.assembler;

import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.GiftStatisticsRes;
import com.example.myicecreambox.gift.dto.response.GiftsStatisticsRes;
import com.example.myicecreambox.gift.entity.Gift;
import com.example.myicecreambox.gift.entity.GiftCategory;
import com.example.myicecreambox.gift.entity.UserGift;
import com.example.myicecreambox.gift.exception.GiftIceCreamKeyMissingValueException;
import com.example.myicecreambox.gift.exception.GiftMessageMissingValueException;
import com.example.myicecreambox.gift.exception.GiftSenderNicknameMissingValueException;
import com.example.myicecreambox.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GiftAssembler {
  public Gift toEntity(String message, String iceCreamName) {
    return Gift.builder().message(message).giftCategory(GiftCategory.getGiftCategoryByName(iceCreamName)).build();
  }

  public List<UserGift> toUpdateAssociation(User sender, User receiver, Gift gift) {

    return null;
  }

  public void toUpdateGiftChance(User sender, User receiver) {
    sender.decreaseGiftChance(sender.getGiftChance());
    receiver.increaseGiftChance(receiver.getGiftChance());
  }

  public GiftsStatisticsRes toGiftStatisticsByIceCreamStatus(List<Gift> receivedGifts) {
    Map<Gift, Long> giftStatusList = new HashMap<>();

    for (Gift gift : receivedGifts) {
      Long giftSize = 0L;
      for (GiftCategory giftCategory : GiftCategory.values()) {
        if(gift.getGiftCategory().equals(giftCategory)) giftSize++;
      }
      giftStatusList.put(gift, giftSize);
    }

    int sum = receivedGifts.size();
    List<GiftStatisticsRes> giftStatisticsRes = new ArrayList<>();
    for (Map.Entry<Gift, Long> entry : giftStatusList.entrySet()) {
      Gift gift = entry.getKey();
      giftStatisticsRes.add(new GiftStatisticsRes(gift.getGiftCategory().getName(), gift.getMessage(), calPercentage(entry.getValue().intValue(), sum), entry.getValue()));
    }
    return GiftsStatisticsRes.toDto(giftStatisticsRes);
  }

  public static double calPercentage(int val, int sum) {
    if(sum == 0) return 0.0;
    return Math.round(((double) val /sum) * 100.0)/100.0;
  }

  public Boolean checkGiftInfo(SendGiftReq sendGiftReq) {
    if (!StringUtils.hasText(sendGiftReq.getMessage())) throw new GiftMessageMissingValueException();
    if (!StringUtils.hasText(sendGiftReq.getIceCreamName())) throw new GiftIceCreamKeyMissingValueException();
    if (!StringUtils.hasText(sendGiftReq.getSenderNickname())) throw new GiftSenderNicknameMissingValueException();
    return true;
  }
}
