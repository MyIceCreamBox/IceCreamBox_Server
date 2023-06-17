package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.response.GiftsStatisticsRes;
import com.example.myicecreambox.gift.dto.request.SendGiftReq;

import java.util.UUID;

public interface GiftService {
  Long sendGift(SendGiftReq sendGiftReq, Long userIdx);

  Integer getMyGiftCount(Long userIdx);

  GiftsStatisticsRes getMyGiftStatistics(Long userIdx);

  Integer getMyGiftChance(Long userIdx);

}
