package com.example.demo.controller;

import com.example.demo.model.AddSchoolRequestM;
import com.example.demo.model.AddStudentRequestM;
import com.example.demo.model.SchoolM;
import com.example.demo.model.StudentM;
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
    SchoolService schoolService;

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
    public ResponseEntity<String> addSchool(@RequestBody AddSchoolRequestM req) {
        String ret = schoolService.addSchool(req.getSchoolName());

        return new ResponseEntity(ret, OK);
    }
    /// endregion

    /// region StudentInfo
    @RequestMapping(value = "/findStudentInfo", method = RequestMethod.GET)
    public ResponseEntity<List<StudentM>> findAllStudent() {
        List<StudentM> studentMList = schoolService.findStudentInfo();

        return new ResponseEntity(studentMList, OK);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResponseEntity<String> addStudent(@RequestBody AddStudentRequestM req) {
        String ret = schoolService.addStudent(req.getStudentName(), req.getSchoolNo());

        return new ResponseEntity(ret, OK);
    }
    /// endregion
}
