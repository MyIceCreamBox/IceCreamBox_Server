package com.example.myicecreambox.user.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

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

  private String nickname;
  private String email;
  private String pw;
  private Boolean loginStatus;

  @Builder
  public User(String nickname, String email, String pw) {
    this.nickname = nickname;
    this.email = email;
    this.pw = pw;
  }

  public void login() {
    this.loginStatus = true;
  }

  public void logout() {
    this.loginStatus = false;
  }
}
