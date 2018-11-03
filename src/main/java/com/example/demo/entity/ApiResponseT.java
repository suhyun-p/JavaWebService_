package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseT {
    private String ResultCode;
    private String Message;
    private Object Data;
}
