package com.example.myicecreambox.gift.entity;

import com.example.myicecreambox.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
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

  @Builder
  public Gift(String message, String iceCreamImgKey) {
    this.message = message;
    this.iceCreamImgKey = iceCreamImgKey;
  }

  public static Gift toDto(String message, String iceCreamImgKey) {
    return Gift.builder()
            .message(message)
            .iceCreamImgKey(iceCreamImgKey)
            .build();

  }


}
