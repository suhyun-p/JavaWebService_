package com.example.demo.controller;

import com.example.demo.model.School;
import com.example.demo.model.Student;
import com.example.demo.model.UserEntity;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jpa")
public class JPAController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "findByUserName", method = RequestMethod.GET)
    public String findByUserName() {
        userRepository.save(new UserEntity("윤사장", 60, UserRole.ADMIN));
        UserEntity userEntity = userRepository.findByUserName("윤사장");

        return "나이 : " + userEntity.getAge() + ", 이름 : " + userEntity.getUserName() + ", 생성일 : " + userEntity.getCreatedAt();
    }

    @RequestMapping(value = "findStudentInfo", method = RequestMethod.GET)
    public List<Student> findStudentInfo() {
        return schoolService.findStudentInfo();
    }

    @RequestMapping(value = "findSchoolInfo", method = RequestMethod.GET)
    public List<School> findSchoolInfo() {
        return schoolService.findSchoolInfo();
    }
}
