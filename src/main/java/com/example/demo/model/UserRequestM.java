package com.example.demo.model;

import com.example.demo.enums.Sex;
import com.example.demo.enums.UserType;
import lombok.Getter;
import lombok.Setter;

public final class UserRequestM {

    @Getter
    @Setter
    public class SetType {
        private Long userNo;
        private UserType userType;
    }

    @Getter
    @Setter
    public class SetUser {
        private String nickname;
        private Sex sex;
        private UserType type;
    }
}
