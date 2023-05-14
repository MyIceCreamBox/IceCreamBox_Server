package com.example.myicecreambox.user.dto.Response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class PostNickNameRes {

  private String nickname;
  private Boolean existence;

  @Builder
  public PostNickNameRes(String nickname, boolean existence) {
    this.nickname = nickname;
    this.existence = existence;
  }

  public static PostNickNameRes toDto(String nickname, Boolean existence) {
    return PostNickNameRes.builder()
            .nickname(nickname)
            .existence(existence)
            .build();
  }
}
