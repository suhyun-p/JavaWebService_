package com.example.demo.entity;

import com.example.demo.enums.Sex;
import com.example.demo.enums.UserType;
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
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name = "is_admin", nullable = false, columnDefinition = "false")
    private boolean isAdmin;

    public UserT() {

    }

    public UserT(String nickname, Sex sex, UserType type) {
        this.nickname = nickname;
        this.sex = sex;
        this.type = type;
    }
}

