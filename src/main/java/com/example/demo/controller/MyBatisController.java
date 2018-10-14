package com.example.demo.controller;

import com.example.demo.repository.MyBatisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/mybatis")
public class MyBatisController {
    @Autowired
    MyBatisUserRepository myBatisUserRepository;

    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public ResponseEntity<List> findByUserName() {
        List userInfo = myBatisUserRepository.getUserInfoAll();

        return new ResponseEntity(userInfo, OK);
    }
}
