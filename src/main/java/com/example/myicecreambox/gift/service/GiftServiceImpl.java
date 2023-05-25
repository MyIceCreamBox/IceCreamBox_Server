package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.dto.response.GetIceCreamRateRes;
import com.example.myicecreambox.gift.dto.response.SendGiftRes;
import com.example.myicecreambox.gift.entity.Gift;
import com.example.myicecreambox.gift.entity.GiftType;
import com.example.myicecreambox.gift.entity.UserGift;
import com.example.myicecreambox.gift.repository.GiftRepository;
import com.example.myicecreambox.gift.repository.UserGiftRepository;
import com.example.myicecreambox.user.entity.User;
import com.example.myicecreambox.user.exception.UserNotFoundException;
import com.example.myicecreambox.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GiftServiceImpl implements GiftService {
  UserRepository userRepository;
  GiftRepository giftRepository;

  UserGiftRepository userGiftRepository;
  // gift 보내기
  @Override
  @Transactional
  public SendGiftRes sendGift(SendGiftReq sendGiftReq, Long userIdx, Long receiverIdx) {
    // Gift 객체를 생성 , 안에 들어갈 속성값 message, imgKey
    Gift gift = new Gift();
    gift.toDto(sendGiftReq.getMessage(), sendGiftReq.getIceCreamImgKey());
    Gift savedGift = giftRepository.save(gift);
    Long giftIdx =savedGift.getGiftIdx();

    //받는 사람, 보내는 사람
    User sender = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    User receiver = userRepository.findByUserIdxAndIsEnable(receiverIdx, true).orElseThrow(UserNotFoundException::new);

    UserGift senderGift = UserGift.builder().user(sender).giftType(GiftType.SEND).gift(gift).senderNickname(sendGiftReq.getSenderNickname()).build();
    UserGift receiverGift = UserGift.builder().user(receiver).giftType(GiftType.RECEIVED).gift(gift).senderNickname(sendGiftReq.getSenderNickname()).build();

    userGiftRepository.save(senderGift);
    userGiftRepository.save(receiverGift);

    return SendGiftRes.toDto(giftIdx); // res 인덱스 반환
  }


    //선물 가능한지 check - giftIdx 를 어떻게 뽑을지 모르겠어서 exception 적용 못함
//    private Gift checkGiftInfo(SendGiftReq) throws GiftMessageMissingValueException, GiftIceCreamKeyMissingValueException, GiftSenderNicknameMissingValueException {
//      if (!StringUtils.hasText(sendGiftReq.getMessage())) throw new GiftMessageMissingValueException();
//      if (!StringUtils.hasText(sendGiftReq.getIceCreamImgKey())) throw new GiftIceCreamKeyMissingValueException();
//      if (!StringUtils.hasText(sendGiftReq.getSenderNickname())) throw new GiftSenderNicknameMissingValueException();
//  return giftRepository.findByGiftIdxAndIsEnable(savedGift.getGiftIdx(), true);
//  }

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
