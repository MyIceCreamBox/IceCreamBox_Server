package com.example.myicecreambox.user.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

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

  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID uuid;

  @Builder
  public User(String nickname, String email, String pw, Integer giftChance, UUID uuid) {
    this.nickname = nickname;
    this.email = email;
    this.pw = pw;
    this.giftChance = giftChance;
    this.uuid = uuid;
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
