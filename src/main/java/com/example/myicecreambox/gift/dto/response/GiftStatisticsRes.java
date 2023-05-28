package com.example.myicecreambox.gift.dto.response;

import lombok.Data;

@Data
public class GiftStatisticsRes {
  private String iceCreamImgUrl;
  private String message;
  private Double percentage;
  private Integer count;
}
