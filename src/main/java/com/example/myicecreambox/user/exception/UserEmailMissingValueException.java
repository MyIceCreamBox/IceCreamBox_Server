package com.example.myicecreambox.user.exception;

public class UserEmailMissingValueException extends RuntimeException {
  public UserEmailMissingValueException() {super("이메일을 입력하지 않았습니다. 다시 시도해주세요.");}
}
