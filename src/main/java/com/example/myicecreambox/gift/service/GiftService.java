package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.response.GetIceCreamRateRes;
import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.SendGiftRes;

public interface GiftService {
  SendGiftRes sendGift(SendGiftReq sendGiftReq, Long userIdx);

  Long getMyGiftCount(Long userIdx);

  GetIceCreamRateRes getMyIceCreamRate(Long userIdx);
}
