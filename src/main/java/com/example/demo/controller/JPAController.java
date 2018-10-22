package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/jpa")
public class JPAController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<UserEntity> addUser(@RequestParam(value = "userName") String userName, @RequestParam(value = "userAge") int userAge, @RequestParam(value = "userRole") UserRole userRole) {
    // public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity user = new UserEntity(userName, userAge, userRole);
        userRepository.save(user);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findByUserName(@RequestParam(value = "userName") String userName) {
        UserEntity user = userRepository.findByUserName(userName);

        return new ResponseEntity(user, OK);
    }
}

