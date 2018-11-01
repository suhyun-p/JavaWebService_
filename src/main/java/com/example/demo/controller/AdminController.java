package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;

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

    /// region SchoolInfo
    @RequestMapping(value = "/school")
    public String School(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/jpa/findSchoolNameList", Object[].class);
        Object[] objects = responseEntity.getBody(); // SchoolM

        model.addAttribute("schoolInfo", objects);

        return "admin/school";
    }

    @RequestMapping(value = "/addSchool", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> AddSchool(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        System.out.println("Add School Test : " + params);
        System.out.println("School Name : " + params.get("schoolName"));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> ret = restTemplate.postForEntity("http://localhost:8080/api/jpa/addSchool", params, String.class);

        System.out.println(ret);

        resultMap.put("schoolName", params.get("schoolName"));
        System.out.println("ret >>>>> " + ret);
        return resultMap;
    }
    /// endregion

    /// region StudentInfo
    // https://brunch.co.kr/@ourlove/69 참조
    @RequestMapping(value = "/student")
    public String Student(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/jpa/findStudentInfo", Object[].class);
        Object[] objects = responseEntity.getBody(); // StudentM

        model.addAttribute("studentlInfo", objects);

        return "admin/student";
    }

    @RequestMapping(value = "/regStudent")
    public String RegStudent(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/jpa/findSchoolNameList", Object[].class);
        Object[] objects = responseEntity.getBody(); // SchoolM

        model.addAttribute("schoolInfo", objects);

        return "admin/regStudent";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> AddStudent(@RequestBody Map<String, Object> params) {

        System.out.println("Log >>>>>> " + params);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> ret = restTemplate.postForEntity("http://localhost:8080/api/jpa/addStudent", params, String.class);

            System.out.println(ret);
        }
        catch(Exception ex) {
            resultMap.put("message", ex.getMessage());
            return resultMap;
        }

        resultMap.put("code", 200);
        resultMap.put("message", "성공적으로 등록되었습니다.");
        System.out.println(resultMap);
        return resultMap;
    }
    /// endregion
}
