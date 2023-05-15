package com.example.myicecreambox.user.exception;

public class UserPwMissingValueException extends RuntimeException {
  public UserPwMissingValueException() {super("비밀번호를 입력하지 않았습니다. 다시 시도해주세요.");}
}
