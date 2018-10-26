package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentM {
    private Long studentNo;
    private String studentName;
    private String schoolName;

    public StudentM(Long studentNo, String studentName, String schoolName) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.schoolName = schoolName;
    }
}
