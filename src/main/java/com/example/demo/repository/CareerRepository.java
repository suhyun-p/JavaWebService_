package com.example.demo.repository;

import com.example.demo.entity.CareerT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository   extends JpaRepository<CareerT, Long> {
    List<CareerT> findAllByUserNoEquals(Long userNo);
}
