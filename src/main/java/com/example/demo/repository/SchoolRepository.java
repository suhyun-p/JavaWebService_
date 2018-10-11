package com.example.demo.repository;

import com.example.demo.entity.SchoolT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolT, Long> {
}