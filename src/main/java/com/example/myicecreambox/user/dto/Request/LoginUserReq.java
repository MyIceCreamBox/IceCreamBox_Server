package com.example.myicecreambox.user.dto.Request;

import lombok.Getter;

@Getter
public class LoginUserReq {
  private String email;
  private String pw;
}
