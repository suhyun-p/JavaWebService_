package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/index")
    public String Index(Model model) {
        model.addAttribute("message", "boot template");

        return "admin/index";
    }

    @RequestMapping(value = "/checkout")
    public String Checkout(Model model) {
        model.addAttribute("message", "boot template");

        return "admin/checkout";
    }

    @RequestMapping(value = "/school")
    public String School(Model model) {
        model.addAttribute("message", "boot template");

        return "admin/school";
    }

    @RequestMapping(value = "/student")
    public String Student(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/jpa/findStudentInfo", Object[].class);
        Object[] objects = responseEntity.getBody(); // StudentM

        model.addAttribute("studentlInfo", objects);

        return "admin/student";
    }
}
