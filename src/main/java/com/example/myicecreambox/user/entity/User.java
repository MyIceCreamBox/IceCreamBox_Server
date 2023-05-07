package com.example.myicecreambox.user.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
  @Id
  @Column(name = "userIdx", nullable = false)
  private Long userIdx;

  private String nickname;
  private String email;
  private Provider provider;

}
