package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.GetIceCreamRateRes;
import com.example.myicecreambox.gift.dto.response.SendGiftRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GiftServiceImpl implements GiftService {

  // gift 보내기
  @Override
  @Transactional
  public SendGiftRes sendGift(SendGiftReq sendGiftReq, Long userIdx) {
    return null;
  }

  // 받은 gift 개수 조회
  @Override
  public Long getMyGiftCount(Long userIdx) {
    return null;
  }

  // 아이스크림 종류 비율 조회
  @Override
  public GetIceCreamRateRes getMyIceCreamRate(Long userIdx) {
    return null;
  }


}
