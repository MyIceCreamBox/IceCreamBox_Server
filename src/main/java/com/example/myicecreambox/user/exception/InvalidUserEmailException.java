package com.example.myicecreambox.user.exception;

public class InvalidUserEmailException extends RuntimeException {
  public InvalidUserEmailException() {super("올바르지 않은 이메일 형식입니다. 다시 시도해주세요.");}
}
