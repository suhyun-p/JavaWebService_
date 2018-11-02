package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", nullable = false)
    private Long no;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "type", nullable = false)
    private String type;

    public UserT() {

    }

    public UserT(String nickname, String sex, String type) {
        this.nickname = nickname;
        this.sex = sex;
        this.type = type;
    }
}
