package com.example.myicecreambox.gift.exception;

public class GiftCategoryNotFoundException extends RuntimeException{
  public GiftCategoryNotFoundException() {super("존재하지 않는 아이스크림 카테고리입니다.");}
}
