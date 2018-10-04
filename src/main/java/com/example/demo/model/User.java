package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@ApiModel
@Getter
@Setter
public class User {
    private int userNo;
    private String userId;
    private String email;
    private String uname;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date regDate;

    public User(int userNo, String userId, String email, String uname, Date regDate) {
        this.userNo = userNo;
        this.userId = userId;
        this.email = email;
        this.uname = uname;
        this.regDate = regDate;
    }

    public User() {

    }
}
