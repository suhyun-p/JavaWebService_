package com.example.demo.service;

import com.example.demo.entity.UserT;
import com.example.demo.enums.Sex;
import com.example.demo.enums.UserType;
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

        return ConverToUserM(userRepository.findAll());
    }

    @Transactional
    public String setUser(String nickname, Sex sex) {
        UserT user = new UserT(nickname, sex);

        userRepository.save(user);

        return "OK";
    }

    @Transactional
    public String setType(Long userNo, UserType userType) {
        UserT user = userRepository.getOne(userNo);
        user.setType(userType);

        userRepository.save(user);

        return "OK";
    }

    @Transactional
    public List<UserM> getTutorList() {

        return ConverToUserM(userRepository.findAllByTypeEquals(UserType.Tutor));
    }

    @Transactional
    public List<UserM> getUserListByNickname(String nickname) {

        System.out.println(nickname);
        System.out.println(userRepository.findAllByNicknameContaining(nickname));
        return ConverToUserM(userRepository.findAllByNicknameContaining(nickname));
    }

    /// region Converter

    public UserM ConverToUserM (UserT t) {
        UserM m = new UserM();
        m.setNo(t.getNo());
        m.setNickname(t.getNickname());
        m.setSex(t.getSex().getValue());
        m.setType(t.getType().getValue());
        m.setTutor(t.getType().equals(UserType.Tutor)); // isTutor
        m.setAdmin(t.isAdmin()); // isAdmin

        return m;
    }

    public List<UserM> ConverToUserM (List<UserT> userTList) {
        List<UserM> userMList = new ArrayList<>();

        for (UserT t : userTList) {
            userMList.add(ConverToUserM(t));
        }

        return userMList;
    }
    /// endregion
}
