package com.example.demo.controller;

import com.example.demo.model.FreeBoardVO;
import com.example.demo.model.UserVO;
import com.example.demo.repository.FreeBoardRepository;
import com.example.demo.repository.MyBatisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/mybatis")
public class MyBatisController {
    @Autowired
    MyBatisUserRepository myBatisUserRepository;

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @RequestMapping(value = "/getUserInfoAll", method = RequestMethod.GET)
    public ResponseEntity<List> getUserInfoAll() {
        List userInfo = myBatisUserRepository.getUserInfoAll();

        return new ResponseEntity(userInfo, OK);
    }

    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
    // public ResponseEntity<String> addUserInfo(@RequestParam(value = "id") String id, @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
    public ResponseEntity<String> addUser(@RequestBody UserVO userVO) {
        // UserVO user = new UserVO(id, userName, password);
        UserVO user = new UserVO(userVO.getId(), userVO.getUserName(), userVO.getPassword());
        myBatisUserRepository.adduserInfo(user);

        return new ResponseEntity("OK", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findByUserNameLike", method = RequestMethod.GET)
    public ResponseEntity<UserVO> findByUserNameLike(@RequestParam(value = "userName") String userName) {
        List users = myBatisUserRepository.findByUserNameLike(userName);

        return new ResponseEntity(users, OK);
    }

    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public ResponseEntity<UserVO> findByUserName(@RequestParam(value = "userName") String userName) {
        UserVO user = myBatisUserRepository.findByUserName(userName);

        return new ResponseEntity(user, OK);
    }

    @RequestMapping(value = "/registBoard", method = RequestMethod.POST)
    public ResponseEntity<String> registBoard(@RequestParam(value = "userName") String userName, @RequestParam(value = "category") String category, @RequestParam(value = "title") String title, @RequestParam(value = "content") String content) {
        FreeBoardVO board = new FreeBoardVO(userName, category, title, content);
        freeBoardRepository.registBoard(board);

        return new ResponseEntity("OK", HttpStatus.CREATED);
    }
}
