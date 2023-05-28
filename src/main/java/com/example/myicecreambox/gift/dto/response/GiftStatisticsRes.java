package com.example.myicecreambox.gift.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class GiftStatisticsRes {
  private String iceCreamName;
  private String message;
  private Double percentage;
  private Integer count;

  public GiftStatisticsRes(String iceCreamName, String message, double percentage, Long count) {
    this.iceCreamName = iceCreamName;
    this.message = message;
    this.percentage = percentage;
    this.count = count.intValue();
  }
}
