package com.example.myicecreambox.user.service;

import com.example.myicecreambox.gift.entity.Gift;
import com.example.myicecreambox.gift.entity.GiftType;
import com.example.myicecreambox.gift.entity.UserGift;
import com.example.myicecreambox.gift.repository.GiftRepository;
import com.example.myicecreambox.gift.repository.UserGiftRepository;
import com.example.myicecreambox.global.utils.TokenUtils;
import com.example.myicecreambox.user.dto.Response.IceCreamBoxRes;
import com.example.myicecreambox.user.dto.Response.PostEmailRes;
import com.example.myicecreambox.user.dto.Request.*;
import com.example.myicecreambox.user.dto.Response.PostNickNameRes;
import com.example.myicecreambox.user.dto.Response.PostUserRes;
import com.example.myicecreambox.user.dto.assembler.UserAssembler;
import com.example.myicecreambox.user.entity.User;
import com.example.myicecreambox.user.exception.*;
import com.example.myicecreambox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserGiftRepository userGiftRepository;
  private final GiftRepository giftRepository;
  private final BCryptPasswordEncoder pwEncoder;
  private final UserAssembler userAssembler;
  private final TokenUtils tokenUtils;

  @Override
  @Transactional
  public PostUserRes join(PostUserReq postUserReq) {
    checkUserInfo(postUserReq.getEmail(), postUserReq.getPw());
    if(!StringUtils.hasText(postUserReq.getNickname())) throw new InvalidUserNickNameException();

    if(userRepository.findByEmail(postUserReq.getEmail()).isPresent()) throw new AlreadyExistEmailException();
    User user = userRepository.save(userAssembler.toEntity(postUserReq, pwEncoder.encode(postUserReq.getPw())));
    user.login();
    return PostUserRes.toDto(tokenUtils.createToken(user));
  }

  @Override
  @Transactional
  public PostUserRes login(LoginUserReq loginUserReq) {
    checkUserInfo(loginUserReq.getEmail(), loginUserReq.getPw());
    User user = userRepository.findByEmail(loginUserReq.getEmail()).orElseThrow(InvalidLoginRequestException::new);
    if(!pwEncoder.matches(loginUserReq.getPw(), user.getPw())) throw new PasswordNotMatchException();
    if (user.getIsEnable().equals(false)) throw new AlreadyWithdrawUserException();
    user.login();
    return PostUserRes.toDto(tokenUtils.createToken(user));
  }

  @Override
  public void logout(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    user.logout();
  }

  public void checkUserInfo(String email, String password) {
    if (!StringUtils.hasText(email)) throw new UserEmailMissingValueException();
    if (!StringUtils.hasText(password)) throw new UserPwMissingValueException();
  }


  @Override
  @Transactional
  public void deleteUser(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    userRepository.delete(user);
  }

  @Override
  public PostNickNameRes checkNickname(PostNicknameReq postNicknameReq) {
    if (!userAssembler.isValidNickname(postNicknameReq.getNickname())) throw new InvalidUserNickNameException();
    Boolean existence = userRepository.existsByNickname(postNicknameReq.getNickname());

    return PostNickNameRes.toDto(postNicknameReq.getNickname(), existence);
  }

  @Override
  public PostEmailRes checkEmail(PostEmailReq postEmailReq) {
    if (!userAssembler.isValidEmail(postEmailReq.getEmail())) throw new InvalidUserEmailException();
    Boolean existence = userRepository.existsByEmail(postEmailReq.getEmail());
    return PostEmailRes.toDto(postEmailReq.getEmail(), existence);
  }

  @Override
  public IceCreamBoxRes getMyIceCreamBox(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    List<UserGift> userGifts = userGiftRepository.findByUserAndGiftType(user, GiftType.RECEIVED);
    List<Gift> receivedGifts = userGifts.stream().map(m -> giftRepository.findByGiftIdxAndIsEnable(m.getGift().getGiftIdx(), true)).toList();
    return IceCreamBoxRes.toDto(receivedGifts);
  }

}
