package com.example.myicecreambox.user.service;

import com.example.myicecreambox.user.dto.Response.PostEmailRes;
import com.example.myicecreambox.user.dto.Request.PostEmailReq;
import com.example.myicecreambox.user.dto.Request.LoginUserReq;
import com.example.myicecreambox.user.dto.Request.PostNicknameReq;
import com.example.myicecreambox.user.dto.Request.PostUserReq;
import com.example.myicecreambox.user.dto.Response.PostNickNameRes;
import com.example.myicecreambox.user.dto.Response.PostUserRes;

public interface UserService {
  PostUserRes join(PostUserReq postUserReq);

  PostUserRes login(LoginUserReq loginUserReq);

  PostNickNameRes checkNickname(PostNicknameReq postNicknameReq);

  void deleteUser(Long userIdx);

  void logout(Long userIdx);

  PostEmailRes checkEmail(PostEmailReq postEmailReq);
}
