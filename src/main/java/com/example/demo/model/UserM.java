package com.example.demo.model;

import com.example.demo.enums.Sex;
import com.example.demo.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserM {
    private Long no;
    private String nickname;
    private String sex;
    private String type;
    private boolean isTutor;
    private boolean isAdmin;

    public UserM() {

    }

    public UserM(Long no, String nickname, Sex sex, UserType type, boolean isAdmin) {
        this.no = no;
        this.nickname = nickname;
        this.sex = sex.getValue();
        this.type = type.getValue();
        this.isAdmin = isAdmin;
    }
}
