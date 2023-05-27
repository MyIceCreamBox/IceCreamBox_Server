package com.example.myicecreambox.gift.exception;

public class GiftMessageMissingValueException extends RuntimeException {
    public GiftMessageMissingValueException() {super("메시지가 입력되지 않았습니다. 다시 시도해주세요.");}
}
