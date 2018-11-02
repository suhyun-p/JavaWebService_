package com.example.demo.controller;

import com.example.demo.entity.UserT;
import com.example.demo.model.SetTypeRequestM;
import com.example.demo.model.UserM;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> findAllSchool() {

        return new ResponseEntity(userService.findUserAll(), OK);
    }

    @RequestMapping(value = "/setType", method = RequestMethod.POST)
    public ResponseEntity<String> setType(@RequestBody SetTypeRequestM req) {
        return new ResponseEntity(userService.setType(req.getUserNo(), req.getUserType()), OK);
    }
}