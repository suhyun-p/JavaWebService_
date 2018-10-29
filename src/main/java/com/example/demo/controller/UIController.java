package com.example.demo.controller;

import com.example.demo.model.SchoolM;
import com.example.demo.service.InMemoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UIController {
    @Autowired
    InMemoryProductService inMemoryProductService;

    @RequestMapping(value = "/th")
    public String templatePage(Model model) {
        model.addAttribute("message", "boot template");

        return "th";
    }

    @RequestMapping(value = "/th2")
    public String templatePage2(Model model) {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("color", "red");
        pageMap.put("name", "jam");
        pageMap.put("price", 3000);
        model.addAttribute("product", pageMap);
        return "th2";
    }

    @RequestMapping(value = "/th3")
    public String templatePage3(Model model) {
        model.addAttribute("products", inMemoryProductService.getProductList());
        return "th3";
    }

    @RequestMapping(value = "/th4")
    public String templatePage4(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/jpa/findShcoolInfo", Object[].class);
        Object[] objects = responseEntity.getBody();

        System.out.println(objects);
        System.out.println(objects[0]); // SchoolM

        // model.addAttribute("products", inMemoryProductService.getProductList());
        model.addAttribute("schoolInfo", objects);
        return "th4";
    }
}
