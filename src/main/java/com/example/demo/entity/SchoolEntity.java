package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCHOOL_ID")
    private Long id;
    private String name;
    private String address;
    private String telnumber;

    @OneToMany(mappedBy = "school")
    private Set<StudentEntity> students;

    public void registerStudent(StudentEntity s) {
        if (students == null) {
            students = new HashSet<StudentEntity>();
        }
        students.add(s);
    }

    public SchoolEntity() {
    }

    public SchoolEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<StudentEntity> getStudents() {
        return this.students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", studentSet=" + students +
                '}';
    }
}
