package com.example.demo.repository;

import com.example.demo.entity.UserT;
import com.example.demo.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserT, Long> {
    List<UserT> findAllByTypeEquals(UserType type);
    List<UserT> findAllByNicknameContaining(String nickname);
}