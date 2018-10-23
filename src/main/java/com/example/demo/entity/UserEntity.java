package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity // hibernate-core
public class UserEntity implements Serializable {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public UserEntity() {

    }

    public UserEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
