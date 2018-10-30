package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/index")
    public String Index(Model model) {
        model.addAttribute("message", "boot template");

        return "admin/index";
    }
}
