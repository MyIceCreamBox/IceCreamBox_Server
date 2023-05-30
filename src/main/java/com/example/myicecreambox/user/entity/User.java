package com.example.myicecreambox.user.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@NoArgsConstructor
@Getter
public class User extends BaseEntity {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long userIdx;

  @Setter
  @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
  private Boolean isDenied = false;

  private Integer giftChance;

  private String nickname;
  private String email;
  private String pw;
  private Boolean loginStatus;

  @Builder
  public User(String nickname, String email, String pw, Integer giftChance) {
    this.nickname = nickname;
    this.email = email;
    this.pw = pw;
    this.giftChance = giftChance;
  }

  public void login() {
    this.loginStatus = true;
  }

  public void logout() {
    this.loginStatus = false;
  }

  public void decreaseGiftChance(Integer giftChance) {
    this.giftChance = giftChance - 1;
  }

  public void increaseGiftChance(Integer giftChance) {
    this.giftChance = giftChance + 1;
  }
}
