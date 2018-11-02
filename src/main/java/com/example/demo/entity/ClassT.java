package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "class")
public class ClassT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", nullable = false)
    private Long no;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "tutor1", nullable = false)
    private Long tutor1;

    @Column(name = "tutor2")
    private Long tutor2;
}
