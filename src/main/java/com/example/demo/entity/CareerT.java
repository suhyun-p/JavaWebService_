package com.example.demo.entity;

import com.example.demo.enums.CareerType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "career")
public class CareerT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", nullable = false)
    private Long no;

    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CareerType type;

    @Column(name = "career")
    private String career;
}
