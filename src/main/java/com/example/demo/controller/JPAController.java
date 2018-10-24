package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/jpa")
public class JPAController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<UserEntity> addUser(@RequestParam(value = "name") String name) {
        // public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity user = new UserEntity(name);
        userRepository.save(user);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findByName(@RequestParam(value = "name") String name) {
        UserEntity user = userRepository.findByName(name);

        return new ResponseEntity(user, OK);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> user = userRepository.findAll();

        return new ResponseEntity(user, OK);
    }
}
