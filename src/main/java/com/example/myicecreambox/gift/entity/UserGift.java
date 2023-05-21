package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import com.example.myicecreambox.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class UserGift extends BaseEntity {
  @Id
  @Column(name = "userGiftIdx", nullable = false)
  private Long userGiftIdx;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="userIdx")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="giftIdx")
  private Gift gift;

  private GiftType giftType;
  private String senderNickname;
}
