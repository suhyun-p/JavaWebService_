package com.example.demo.controller;

import com.example.demo.model.UserM;
import com.example.demo.model.UserRequsetM.EditUser;
import com.example.demo.model.UserRequsetM.GetUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Convert;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/index")
    public String Index(Model model) {
        return "admin/index";
    }

    @RequestMapping(value = "/user")
    public String User(Model model) {
        return "admin/user";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String EditUser(@ModelAttribute EditUser req, Model model) {
        System.out.println(req);
        System.out.println(req.getUserNo());

        GetUser getUser = new GetUser();
        getUser.setUserNo(Long.valueOf(req.getUserNo()));

        System.out.println(getUser.getUserNo());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserM> ret = restTemplate.postForEntity("http://localhost:8080/api/users/findUser", getUser, UserM.class);

        System.out.println(ret);
        System.out.println(ret.getBody());
        System.out.println(ret.getBody().getNickname());

        model.addAttribute("userInfo", ret.getBody());
        return "admin/editUser";
    }

    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> RegUser(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> ret = restTemplate.postForEntity("http://localhost:8080/api/users/setUser", params, String.class);
        resultMap.put("Message", ret);
        return resultMap;
    }

    @RequestMapping(value = "/enrollTutor", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> EnrollTutor(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> ret = restTemplate.postForEntity("http://localhost:8080/api/users/setType", params, String.class);
        resultMap.put("Message", ret);
        return resultMap;
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> SearchUser(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> ret = restTemplate.postForEntity("http://localhost:8080/api/users/getUserListByNickname", params, String.class);
        resultMap.put("Data", ret);
        return resultMap;
    }

    @RequestMapping(value = "/getCareer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> GetCareer(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> ret = restTemplate.postForEntity("http://localhost:8080/api/careers/getCareer", params, Object.class);
        resultMap.put("Data", ret);
        return resultMap;
    }

    @RequestMapping(value = "/class")
    public String Class(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/classes/getClassList", Object[].class);
        Object[] objects = responseEntity.getBody(); // ClassM

        model.addAttribute("classInfo", objects);

        return "admin/class";
    }

    @RequestMapping(value = "/getClassList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> GetClassList() {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> ret = restTemplate.getForEntity("http://localhost:8080/api/classes/getClassList", Object[].class);
        resultMap.put("Data", ret);
        return resultMap;
    }

    @RequestMapping(value = "/getClass", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> GetClass(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> ret = restTemplate.postForEntity("http://localhost:8080/api/classes/getClass", params, Object.class);
        resultMap.put("Data", ret);
        return resultMap;
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
