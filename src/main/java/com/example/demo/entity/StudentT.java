package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class StudentT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private Long id;
    private String userName;
    private String grade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHOOL_ID")
    private SchoolT school;

    public StudentT() {
    }

    public StudentT(String userName) {
        this.userName = userName;
    }

    public SchoolT getSchool() {
        return school;
    }

    public void setSchool(SchoolT school) {
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /*@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", grade='" + grade + '\'' +
                ", school=" + school +
                '}';
    }*/
}
