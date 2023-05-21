package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.SendGiftReq;
import com.example.myicecreambox.gift.dto.SendGiftRes;

public interface GiftService {
  SendGiftRes sendGift(SendGiftReq sendGiftReq, Long userIdx);
}
