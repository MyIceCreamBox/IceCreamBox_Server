package com.example.myicecreambox.gift.dto.response;

import com.example.myicecreambox.gift.dto.response.GiftStatisticsRes;
import lombok.Data;

import java.util.List;

@Data
public class GiftsStatisticsRes {
  List<GiftStatisticsRes> giftsStatisticsResList;
}
