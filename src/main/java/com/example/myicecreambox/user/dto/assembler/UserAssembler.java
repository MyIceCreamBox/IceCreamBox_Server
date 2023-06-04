package com.example.myicecreambox.user.dto.assembler;

import com.example.myicecreambox.user.dto.Request.PostUserReq;
import com.example.myicecreambox.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class UserAssembler {

  private static final Integer DEFAULT_GIFT_CHANCE_COUNT = 5;
  // todo 공유페이지 url 픽스 후 리팩토링
  private static final String DEFAULT_URL = "http://localhost:8080";
  private static final String GIFT_SEND_PATH = "/gifts/send";
  private static final String SLASH = "/";

  public User toEntity(PostUserReq postUserReq, String pw) {
    return User.builder()
            .email(postUserReq.getEmail())
            .pw(pw)
            .nickname(postUserReq.getNickname())
            .giftChance(DEFAULT_GIFT_CHANCE_COUNT)
            .build();
  }

  //  2자 이상 8자 이하, 영어 또는 숫자 또는 한글로 구성
//  특이사항 : 한글 초성 및 모음은 허가하지 않는다.
  public Boolean isValidNickname(String nickname) {
    boolean err = false;
    String regex = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,8}$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(nickname);
    if(m.matches()) {
      err = true;
    }
    return err;
  }

  public Boolean isValidEmail(String email) {
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public String toPersonalUrl(Long userIdx) {
    return DEFAULT_URL + GIFT_SEND_PATH + SLASH + userIdx;
  }
}
