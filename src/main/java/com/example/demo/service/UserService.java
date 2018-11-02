package com.example.demo.service;

import com.example.demo.entity.UserT;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<UserT> findUserAll() {
        List<UserT> userTList = userRepository.findAll();

        return userTList;
    }

    @Transactional
    public String setType(Long userNo, String userType) {
        UserT user = userRepository.getOne(userNo);
        user.setType(userType);
        userRepository.save(user);

        return "OK";
    }
}
