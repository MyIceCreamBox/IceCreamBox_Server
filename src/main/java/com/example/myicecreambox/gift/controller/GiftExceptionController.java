package com.example.myicecreambox.gift.controller;

import com.example.myicecreambox.gift.exception.GiftIceCreamKeyMissingValueException;
import com.example.myicecreambox.gift.exception.GiftMessageMissingValueException;
import com.example.myicecreambox.gift.exception.GiftSenderNicknameMissingValueException;
import com.example.myicecreambox.gift.exception.NotEnoughGiftChanceException;
import com.example.myicecreambox.global.dto.ResponseCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GiftExceptionController {

  @ExceptionHandler(NotEnoughGiftChanceException.class)
  public ResponseCustom<?> catchNotEnoughGiftChanceException(NotEnoughGiftChanceException e) {
    log.error(e.getMessage());
    return ResponseCustom.FORBIDDEN(e.getMessage());
  }

  @ExceptionHandler(GiftIceCreamKeyMissingValueException.class)
  public ResponseCustom<?> catchGiftIceCreamKeyMissingValueException(GiftIceCreamKeyMissingValueException e) {
    log.error(e.getMessage());
    return ResponseCustom.BAD_REQUEST(e.getMessage());
  }

  @ExceptionHandler(GiftMessageMissingValueException.class)
  public ResponseCustom<?> catchGiftMessageMissingValueException(GiftMessageMissingValueException e) {
    log.error(e.getMessage());
    return ResponseCustom.BAD_REQUEST(e.getMessage());
  }

  @ExceptionHandler(GiftSenderNicknameMissingValueException.class)
  public ResponseCustom<?> catchGiftSenderNicknameMissingValueException(GiftSenderNicknameMissingValueException e) {
    log.error(e.getMessage());
    return ResponseCustom.BAD_REQUEST(e.getMessage());
  }


}
