package com.example.myicecreambox.user.dto.Request;

import lombok.Getter;

@Getter
public class PostUserReq {
  private String pw;
  private String email;
  private String nickname;
}
