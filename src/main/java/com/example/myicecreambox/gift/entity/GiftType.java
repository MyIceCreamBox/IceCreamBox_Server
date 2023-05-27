package com.example.myicecreambox.gift.entity;

import lombok.Getter;

@Getter
public enum GiftType {
  RECEIVED(0, "receiver"),
  SEND(1, "sender");

  private int number;
  private String value;

  GiftType(int number, String value) {
    this.number = number;
    this.value = value;
  }
}
