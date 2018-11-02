package com.example.demo.model;

import com.example.demo.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetTypeRequestM {
    private Long userNo;
    private UserType userType;
}