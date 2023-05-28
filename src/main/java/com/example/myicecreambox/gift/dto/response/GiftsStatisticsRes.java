package com.example.myicecreambox.gift.dto.response;

import com.example.myicecreambox.gift.dto.response.GiftStatisticsRes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GiftsStatisticsRes {
  List<GiftStatisticsRes> giftsStatisticsResList;


  public static GiftsStatisticsRes toDto(List<GiftStatisticsRes> giftStatisticsRes) {
    return GiftsStatisticsRes.builder().giftsStatisticsResList(giftStatisticsRes).build();
  }
}
