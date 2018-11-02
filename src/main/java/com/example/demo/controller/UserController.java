package com.example.demo.controller;

import com.example.demo.entity.UserT;
import com.example.demo.model.User;
import com.example.demo.model.UserM;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ResponseEntity<List<UserT>> findAllSchool() {
        List<UserT> userTList = userService.findUserAll();
        List<UserM> userMList = new ArrayList<>();

        for(UserT t : userTList) {
            userMList.add(new UserM(t.getNo(), t.getNickname(), t.getSex(), t.getType()));
        }

        return new ResponseEntity(userMList, OK);
    }
}