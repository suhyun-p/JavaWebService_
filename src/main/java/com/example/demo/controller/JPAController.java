package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRole;
import com.example.demo.model.SchoolM;
import com.example.demo.model.StudentM;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/jpa")
public class JPAController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SchoolService schoolService;

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

    @RequestMapping(value = "/findStudentInfo", method = RequestMethod.GET)
    public ResponseEntity<List<StudentM>> findStudentInfo() {
        List<StudentM> findStudentInfoResponse = schoolService.findStudentInfo();

        return new ResponseEntity(findStudentInfoResponse, OK);
    }

    @RequestMapping(value = "/findSchoolInfo", method = RequestMethod.GET)
    public ResponseEntity<List<SchoolM>> findSchoolInfo() {
        List<SchoolM> findSchoolInfoResponse = schoolService.findSchoolInfo();
        return new ResponseEntity(findSchoolInfoResponse, OK);
    }
}

