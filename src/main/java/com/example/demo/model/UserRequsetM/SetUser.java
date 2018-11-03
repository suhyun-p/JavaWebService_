package com.example.demo.model.UserRequsetM;

import com.example.demo.enums.Sex;
import com.example.demo.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetUser {
    private String nickname;
    private Sex sex;
}
