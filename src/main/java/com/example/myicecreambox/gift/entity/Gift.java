package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Gift extends BaseEntity {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long giftIdx;

  private String message;
  private String senderNickname;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GiftCategory giftCategory;

  @Builder
  public Gift(String message, GiftCategory giftCategory, String senderNickname) {
    this.message = message;
    this.giftCategory = giftCategory;
    this.senderNickname = senderNickname;
  }
}
