package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Gift extends BaseEntity {
  @Id
  @Column(name = "giftIdx", nullable = false)
  private Long giftIdx;

  private String message;
  private String iceCreamImgKey;


}
