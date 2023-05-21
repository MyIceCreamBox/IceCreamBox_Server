package com.example.myicecreambox.gift.repository;

import com.example.myicecreambox.gift.entity.GiftType;
import com.example.myicecreambox.gift.entity.UserGift;
import com.example.myicecreambox.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGiftRepository extends JpaRepository<UserGift, Long> {
  List<UserGift> findByUserAndGiftType(User user, GiftType giftType);
}
