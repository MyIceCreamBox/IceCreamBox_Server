package com.example.myicecreambox.user.repository;

import com.example.myicecreambox.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserIdxAndIsEnable(Long userIdx, Boolean isEnable);

  Optional<User> findByUuidAndIsEnable(UUID uuid, Boolean isEnable);

  Optional<User> findByEmailAndPw(String email, String pw);

  Boolean existsByNickname(String nickName);

  Boolean existsByEmail(String email);

  Optional<User> findByEmail(String email);

  Optional<User> findByNicknameAndIsEnable(String receiverNickname, Boolean isEnable);
}
