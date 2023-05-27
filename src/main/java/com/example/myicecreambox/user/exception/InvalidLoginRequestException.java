package com.example.myicecreambox.user.exception;

public class InvalidLoginRequestException extends RuntimeException{
  public InvalidLoginRequestException() {super("해당 이메일을 가진 유저가 존재하지 않습니다.");}
}
