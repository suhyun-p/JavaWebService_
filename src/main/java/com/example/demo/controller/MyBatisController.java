package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.UserVO;
import com.example.demo.repository.MyBatisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/mybatis")
public class MyBatisController {
    @Autowired
    MyBatisUserRepository myBatisUserRepository;

    @RequestMapping(value = "findStudentInfo", method = RequestMethod.GET)
    public List findStudentInfo() {
        return myBatisUserRepository.getUserInfoAll();
    }

    @RequestMapping(value = "addUserInfo", method = RequestMethod.GET)
    public List addUserInfo() {
        UserVO userVO = new UserVO("test4", "jpub", "qwer1234");
        myBatisUserRepository.addUserInfo(userVO);

        return myBatisUserRepository.getUserInfoAll();
    }

    @RequestMapping(value = "findByUserName", method = RequestMethod.GET)
    public UserVO findByUserName() {
        UserVO userVO = myBatisUserRepository.findByUserName("jpub");
        return userVO;
    }
}
