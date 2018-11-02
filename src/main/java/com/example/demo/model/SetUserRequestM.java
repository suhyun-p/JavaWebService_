package com.example.demo.model;

import com.example.demo.enums.Sex;
import com.example.demo.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetUserRequestM {
    private String nickname;
    private Sex sex;
    private UserType type;
}
