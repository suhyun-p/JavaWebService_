package com.example.demo.controller;

import com.example.demo.model.UserM;
import com.example.demo.model.UserRequsetM.SetType;
import com.example.demo.model.UserRequsetM.SetUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> getUserList() {

        return new ResponseEntity(userService.findUserAll(), OK);
    }

    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    public ResponseEntity<String> setUser(@RequestBody SetUser req) {
        return new ResponseEntity(userService.setUser(req.getNickname(), req.getSex(), req.getType()), OK);
    }

    @RequestMapping(value = "/setType", method = RequestMethod.POST)
    public ResponseEntity<String> setType(@RequestBody SetType req) {
        System.out.println("User Controller");
        return new ResponseEntity(userService.setType(req.getUserNo(), req.getUserType()), OK);
    }

    @RequestMapping(value = "/getTutorList", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> getTutorList() {

        return new ResponseEntity(userService.getTutorList(), OK);
    }
}