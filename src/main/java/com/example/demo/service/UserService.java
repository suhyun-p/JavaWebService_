package com.example.demo.service;

import com.example.demo.entity.UserT;
import com.example.demo.model.UserM;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<UserM> findUserAll() {
        List<UserT> userTList = userRepository.findAll();
        System.out.println(userTList);

        List<UserM> userMList = new ArrayList<>();

        for(UserT t : userTList) {
            userMList.add(new UserM(t.getNo(), t.getNickname(), t.getSex(), t.getType()));
        }

        return userMList;
    }

    public UserT setUser(String nickname, String sex, String type) {
        UserT user = new UserT(nickname, sex, type);
        user.setType(type);

        userRepository.save(user);

        return user;
    }

    @Transactional
    public String setType(Long userNo, String userType) {
        UserT user = userRepository.getOne(userNo);
        user.setType(userType);

        userRepository.save(user);

        return "OK";
    }
}
