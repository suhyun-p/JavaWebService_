package com.example.demo.controller;

import com.example.demo.model.UserM;
import com.example.demo.model.UserRequsetM.GetUserListByNickname;
import com.example.demo.model.UserRequsetM.SetType;
import com.example.demo.model.UserRequsetM.SetUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public Map<String, Object> getUserList() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", userService.findUserAll());

        return resultMap;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> getUser() {

        return new ResponseEntity(userService.findUserAll(), OK);
    }

    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    public ResponseEntity<String> setUser(@RequestBody SetUser req) {
        return new ResponseEntity(userService.setUser(req.getNickname(), req.getSex()), OK);
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

    @RequestMapping(value = "/getUserListByNickname", method = RequestMethod.POST)
    public ResponseEntity<List<UserM>> getUserListByNickname(@RequestBody GetUserListByNickname req) {

        return new ResponseEntity(userService.getUserListByNickname(req.getNickname()), OK);
    }
}