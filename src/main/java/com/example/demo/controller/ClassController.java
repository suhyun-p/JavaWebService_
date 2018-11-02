package com.example.demo.controller;

import com.example.demo.entity.ClassT;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/classes")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getClassList", method = RequestMethod.GET)
    public ResponseEntity<List<ClassT>> getClassList() {

        return new ResponseEntity(classService.findClassAll(), HttpStatus.OK);
    }
}
