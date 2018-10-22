package com.example.demo.model;

import com.example.demo.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SchoolM {
    private String name;
    private String address;
    private String telnumber;
    private List<String> students;

    public SchoolM() {

    }

    public SchoolM(String name, Set<StudentEntity> students) {
        this.name = name;
        if (this.students == null) {
            this.students = new ArrayList<String>();
        }

        for (StudentEntity s : students) {
            this.students.add(s.getUserName());
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelnumber() {
        return this.telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public List<String> getStudents() {
        return this.students;
    }

    public void setStudents(String student) {
        this.students.add(student);
    }
}