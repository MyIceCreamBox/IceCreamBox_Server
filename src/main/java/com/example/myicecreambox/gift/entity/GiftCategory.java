package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.gift.exception.GiftCategoryNotFoundException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum GiftCategory {

  // todo 아이스크림 벨류 픽스되면 변경
  ICECREAM1("아이스크림1"),
  ICECREAM2("아이스크림2"),
  ICECREAM3("아이스크림3"),
  ICECREAM4("아이스크림4"),
  ICECREAM5("아이스크림5"),
  ICECREAM6("아이스크림6"),
  ICECREAM7("아이스크림7"),
  ICECREAM8("아이스크림8"),
  ICECREAM9("아이스크림9");

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
