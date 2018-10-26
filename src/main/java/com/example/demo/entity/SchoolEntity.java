package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "school_table")
public class SchoolEntity {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_no", nullable = false)
    private Long schoolNo;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @OneToMany(mappedBy = "school") // "private SchoolEntity [school];" in StudentEntity
    @JsonIgnore // 재귀호출 방지
    private List<StudentEntity> students;
}
