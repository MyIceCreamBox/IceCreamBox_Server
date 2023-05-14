package com.example.myicecreambox.user.repository;

import com.example.myicecreambox.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserIdxAndIsEnable(Long userIdx, Boolean isEnable);

  User findByEmailAndPw(String email, String pw);

  Boolean existsByNickname(String nickName);

  Boolean existsByEmail(String email);
}
