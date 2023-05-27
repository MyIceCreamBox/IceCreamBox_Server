package com.example.myicecreambox.user.exception;

public class AlreadyExistEmailException extends RuntimeException {
  public AlreadyExistEmailException() {super("이미 존재하는 이메일입니다.");}
}
