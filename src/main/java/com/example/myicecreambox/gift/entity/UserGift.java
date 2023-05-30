package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import com.example.myicecreambox.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class UserGift extends BaseEntity {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long userGiftIdx;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="userIdx")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="giftIdx")
  private Gift gift;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GiftType giftType;

  @Builder
  public UserGift(User user, GiftType giftType, Gift gift) {
    this.user = user;
    this.giftType = giftType;
    this.gift = gift;
  }

  public static UserGift toEntity(User user, GiftType giftType, Gift gift) {
    return UserGift.builder()
            .user(user)
            .gift(gift)
            .giftType(giftType)
            .build();
  }


}
