package com.example.myicecreambox.user.dto.Response;

import lombok.Builder;
import lombok.Data;

@Data
public class PostEmailRes {
  private String email;
  private Boolean existence;

  @Builder
  public PostEmailRes(String email, Boolean existence) {
    this.email = email;
    this.existence = existence;
  }

  public static PostEmailRes toDto(String email, Boolean existence) {
    return PostEmailRes.builder()
            .email(email)
            .existence(existence)
            .build();
  }
}
