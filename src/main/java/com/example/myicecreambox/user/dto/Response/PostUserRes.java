package com.example.myicecreambox.user.dto.Response;

import lombok.Builder;
import lombok.Data;

import static com.example.myicecreambox.global.utils.TokenUtils.COMMA;

@Data
public class PostUserRes {
  private String accessToken;
  private String refreshToken;

  @Builder
  public PostUserRes(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

  public static PostUserRes toDto(String token) {
    String accessToken = token.split(COMMA)[0];
    String refreshToken = token.split(COMMA)[1];

    return PostUserRes.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .build();
  }
}
