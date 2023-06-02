package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.gift.exception.GiftCategoryNotFoundException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum GiftCategory {

  LOVE_BAR("이거먹으면나랑사귀는바"),
  A_PLUS_BAR("이거먹으면에이쁠받는바"),
  COLD_BAR("이거먹으면추워바"),
  BLACK_BAR("흑마법사가만든저체온증바"),
  PITCH_BAR("쿨복숭아쌍쌍바"),
  CHOCOLATE_BAR("초콜릿태닝쌍쌍바"),
  FISH_CON("물고기도반한에어콘"),
  ORANGE_CON("여름이온지얼마나오렌지콘"),
  HOT_CON("베리베리더워콘");

  private String name;

  GiftCategory(String name) {
    this.name = name;
  }

  public static GiftCategory getGiftCategoryByName(String name){
    return Arrays.stream(GiftCategory.values())
            .filter(r -> r.getName().equals(name))
            .findAny().orElseThrow(GiftCategoryNotFoundException::new);
  }
}
