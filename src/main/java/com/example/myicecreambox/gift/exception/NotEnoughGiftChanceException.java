package com.example.myicecreambox.gift.exception;

public class NotEnoughGiftChanceException extends RuntimeException {
  public NotEnoughGiftChanceException() {super("보낼 수 있는 기프트 횟수가 부족합니다. 메시지를 받으면 기회를 얻을 수 있습니다.");}
}
