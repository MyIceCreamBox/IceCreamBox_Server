package com.example.myicecreambox.user.service;

import com.example.myicecreambox.global.utils.TokenUtils;
import com.example.myicecreambox.user.dto.Response.PostEmailRes;
import com.example.myicecreambox.user.dto.Request.*;
import com.example.myicecreambox.user.dto.Response.PostNickNameRes;
import com.example.myicecreambox.user.dto.Response.PostUserRes;
import com.example.myicecreambox.user.dto.assembler.UserAssembler;
import com.example.myicecreambox.user.entity.User;
import com.example.myicecreambox.user.exception.*;
import com.example.myicecreambox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserAssembler userAssembler;
  private final TokenUtils tokenUtils;

  @Override
  @Transactional
  public PostUserRes join(PostUserReq postUserReq) {
    User user = checkUserInfo(postUserReq.getEmail(), postUserReq.getPw());
    if (user == null) {
      user = saveUser(postUserReq);
    }
    user.login();
    return PostUserRes.toDto(tokenUtils.createToken(user));
  }

  private User saveUser(PostUserReq postUserReq) {
    return userRepository.save(userAssembler.toEntity(postUserReq));

  }

  @Override
  public PostUserRes login(LoginUserReq loginUserReq) {
    User user = checkUserInfo(loginUserReq.getEmail(), loginUserReq.getPw());
    if (user.getIsEnable().equals(false)) throw new AlreadyWithdrawUserException();
    user.login();
    return PostUserRes.toDto(tokenUtils.createToken(user));
  }

  @Override
  public void logout(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    user.logout();
  }

  @Override
  public void deleteUser(Long userIdx) {
    User user = userRepository.findByUserIdxAndIsEnable(userIdx, true).orElseThrow(UserNotFoundException::new);
    userRepository.delete(user);
  }

  public User checkUserInfo(String email, String pw) {
    if (!StringUtils.hasText(email)) throw new UserEmailMissingValueException();
    if (!StringUtils.hasText(pw)) throw new UserPwMissingValueException();

    return userRepository.findByEmailAndPwAndIsEnable(email, pw, true);
  }

  @Override
  public PostNickNameRes checkNickname(PostNicknameReq postNicknameReq) {
    if (!userAssembler.isValidNickname(postNicknameReq.getNickname())) throw new InvalidUserNickNameException();
    Boolean existence = userRepository.existsByNickname(postNicknameReq.getNickname());

    return PostNickNameRes.toDto(postNicknameReq.getNickname(), existence);
  }

  @Override
  public PostEmailRes checkEmail(PostEmailReq postEmailReq) {
    if(!userAssembler.isValidEmail(postEmailReq.getEmail())) throw new InvalidUserEmailException();
    Boolean existence = userRepository.existsByEmail(postEmailReq.getEmail());
    return PostEmailRes.toDto(postEmailReq.getEmail(), existence);

  }


}
