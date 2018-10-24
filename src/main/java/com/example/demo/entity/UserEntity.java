package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
create table user_table (
    no bigint not null auto_increment,
    name varchar(10) not null,
    primary key(no)
);
 */

@Entity // hibernate-core
@Table(name = "user_table")
public class UserEntity implements Serializable {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", nullable = false)
    private Long no;

    @Column(name = "name", nullable = false)
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
