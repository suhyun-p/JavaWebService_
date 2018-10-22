package com.example.demo.model;

public class StudentM {
    private String userName;
    private String grade;
    private String school;

    public StudentM() {

    }

    public StudentM(String userName, String grade, String school) {
        this.userName = userName;
        this.grade = grade;
        this.school = school;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
