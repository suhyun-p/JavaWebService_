package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "student_table")
public class StudentEntity {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_no", nullable = false)
    private Long studentNo;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @ManyToOne(targetEntity = SchoolEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_no")
    private SchoolEntity school;
}
