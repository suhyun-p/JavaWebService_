package com.example.demo.repository;

import com.example.demo.entity.ClassT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository  extends JpaRepository<ClassT, Long> {
}
