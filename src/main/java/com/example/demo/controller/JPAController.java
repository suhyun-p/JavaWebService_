package com.example.demo.controller;

import com.example.demo.entity.SchoolEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.SchoolM;
import com.example.demo.model.StudentM;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SchoolService;
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

    @Autowired
    SchoolService schoolService;

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

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> user = userRepository.findAll();

        return new ResponseEntity(user, OK);
    }

    /// region SchoolInfo
    @RequestMapping(value = "/findShcoolInfo", method = RequestMethod.GET)
    public ResponseEntity<List<SchoolM>> findAllSchool() {
        List<SchoolM> schoolEntityList = schoolService.findSchoolInfo();

        return new ResponseEntity(schoolEntityList, OK);
    }

    @RequestMapping(value = "/findSchoolNameList", method = RequestMethod.GET)
    public ResponseEntity<List<SchoolM>> findSchoolNameList() {
        List<SchoolM> schoolEntityList = schoolService.findSchoolNameList();

        return new ResponseEntity(schoolEntityList, OK);
    }

    @RequestMapping(value = "/addSchool", method = RequestMethod.POST)
    public ResponseEntity<String> addSchool(@RequestParam(value = "schoolName") String schoolName) {
        String ret = schoolService.addSchool(schoolName);

        return new ResponseEntity(ret, OK);
    }
    /// endregion

    /// region StudentInfo
    @RequestMapping(value = "/findStudentInfo", method = RequestMethod.GET)
    public ResponseEntity<List<StudentM>> findAllStudent() {
        List<StudentM> studentMList = schoolService.findStudentInfo();

        return new ResponseEntity(studentMList, OK);
    }
    /// endregion
}
