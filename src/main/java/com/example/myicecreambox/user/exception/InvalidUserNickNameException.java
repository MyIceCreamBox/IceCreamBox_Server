package com.example.myicecreambox.user.exception;

public class InvalidUserNickNameException extends RuntimeException {
  public InvalidUserNickNameException() {super("올바르지 않은 닉네임 형식입니다. 다시 시도해주세요.");}
}
