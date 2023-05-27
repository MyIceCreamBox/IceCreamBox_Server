package com.example.myicecreambox.gift.exception;

public class GiftSenderNicknameMissingValueException extends RuntimeException {
    public GiftSenderNicknameMissingValueException() {super("보내는 사람의 닉네임 입력이 완료되지 않았습니다. 다시 입력해 주세요.");}
}
