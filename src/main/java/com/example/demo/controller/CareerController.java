package com.example.demo.controller;

import com.example.demo.model.CareerM;
import com.example.demo.model.CareerRequestM.GetCareer;
import com.example.demo.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/careers")
public class CareerController {
    @Autowired
    CareerService careerService;

    @RequestMapping(value = "/getCareer", method = RequestMethod.POST)
    public ResponseEntity<List<CareerM>> getCareer(@RequestBody GetCareer req) {

        return new ResponseEntity(careerService.findCareer(req.getUserNo()), HttpStatus.OK);
    }
}
