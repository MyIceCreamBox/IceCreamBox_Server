package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.response.GiftsStatisticsRes;
import com.example.myicecreambox.gift.dto.request.SendGiftReq;

public interface GiftService {
  Long sendGift(SendGiftReq sendGiftReq, Long userIdx, Long ReceiverIdx);

  Integer getMyGiftCount(Long userIdx);

  GiftsStatisticsRes getMyGiftStatistics(Long userIdx);

  Integer getMyGiftChance(Long userIdx);
}
