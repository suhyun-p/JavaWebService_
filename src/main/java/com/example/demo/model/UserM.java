package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserM {
    private Long no;
    private String nickname;
    private String sex;
    private String type;
    private boolean isAdmin;

    public UserM(Long no, String nickname, String sex, String type, boolean isAdmin) {
        this.no = no;
        this.nickname = nickname;
        this.sex = sex;
        this.type = type;
        this.isAdmin = isAdmin;
    }
}
