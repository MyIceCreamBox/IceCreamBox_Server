package com.example.myicecreambox.gift.service;

import com.example.myicecreambox.gift.dto.assembler.GiftAssembler;
import com.example.myicecreambox.gift.dto.request.SendGiftReq;
import com.example.myicecreambox.gift.exception.NotEnoughGiftChanceException;
import com.example.myicecreambox.gift.dto.response.GiftsStatisticsRes;
import com.example.myicecreambox.gift.entity.Gift;
import com.example.myicecreambox.gift.entity.GiftType;
import com.example.myicecreambox.gift.entity.UserGift;
import com.example.myicecreambox.gift.exception.GiftIceCreamKeyMissingValueException;
import com.example.myicecreambox.gift.exception.GiftMessageMissingValueException;
import com.example.myicecreambox.gift.exception.GiftSenderNicknameMissingValueException;
import com.example.myicecreambox.gift.repository.GiftRepository;
import com.example.myicecreambox.gift.repository.UserGiftRepository;
import com.example.myicecreambox.user.entity.User;
import com.example.myicecreambox.user.exception.UserNotFoundException;
import com.example.myicecreambox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

  private final UserRepository userRepository;
  private final GiftRepository giftRepository;
  private final UserGiftRepository userGiftRepository;
  private final GiftAssembler giftAssembler;

  // gift 보내기
  @Override
  @Transactional
  public Long sendGift(SendGiftReq sendGiftReq, Long userIdx, Long receiverIdx) {
    User sender = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    User receiver = userRepository.findByUserIdxAndIsEnable(receiverIdx, true).orElseThrow(UserNotFoundException::new);

    if(sender.getGiftChance() <= 0) throw new NotEnoughGiftChanceException();

    Gift gift = new Gift();
    if (this.checkGiftInfo(sendGiftReq)) {
      gift = giftRepository.save(giftAssembler.toEntity(sendGiftReq.getMessage(), sendGiftReq.getIceCreamImgKey()));
      userGiftRepository.save(UserGift.toEntity(sender, GiftType.SEND, gift, sendGiftReq.getSenderNickname()));
      userGiftRepository.save(UserGift.toEntity(receiver, GiftType.RECEIVED, gift, sendGiftReq.getSenderNickname()));
      giftAssembler.toUpdateGiftChance(sender, receiver);
    }
    return gift.getGiftIdx();
  }

  private Boolean checkGiftInfo(SendGiftReq sendGiftReq) {
    if (!StringUtils.hasText(sendGiftReq.getMessage())) throw new GiftMessageMissingValueException();
    if (!StringUtils.hasText(sendGiftReq.getIceCreamImgKey())) throw new GiftIceCreamKeyMissingValueException();
    if (!StringUtils.hasText(sendGiftReq.getSenderNickname())) throw new GiftSenderNicknameMissingValueException();
    return true;
  }

  // 받은 gift 개수 조회
  @Override
  public Integer getMyGiftCount(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    return userGiftRepository.findByUserAndGiftType(user, GiftType.RECEIVED).size();
  }

  // 아이스크림 종류 비율 조회
  @Override
  public GiftsStatisticsRes getMyGiftStatistics(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    List<UserGift> userGifts = userGiftRepository.findByUserAndGiftType(user, GiftType.RECEIVED);
    List<Gift> receivedGifts = userGifts.stream().map(m -> giftRepository.findByGiftIdxAndIsEnable(m.getGift().getGiftIdx(), true)).toList();
    Map<Gift, Long> giftStatusList = new HashMap<>();

    return giftAssembler.toGiftStatisticsByIceCreamStatus(receivedGifts);
  }

  @Override
  public Integer getMyGiftChance(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    return user.getGiftChance();
  }
}
