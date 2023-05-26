package com.example.myicecreambox.gift.exception;

public class GiftIceCreamKeyMissingValueException extends RuntimeException {
    public GiftIceCreamKeyMissingValueException() {super("아이스크림이 선택되지 않았습니다. 다시 선택해 주세요.");}
}
