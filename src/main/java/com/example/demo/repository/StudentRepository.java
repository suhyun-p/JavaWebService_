package com.example.demo.repository;

import com.example.demo.entity.StudentT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentT, Long> {
}