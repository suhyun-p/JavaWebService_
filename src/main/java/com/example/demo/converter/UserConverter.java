package com.example.demo.converter;

import com.example.demo.entity.UserT;
import com.example.demo.model.UserM;

import java.util.ArrayList;
import java.util.List;

public final class UserConverter {

    public UserM ConverToUserM (UserT t) {
        UserM m = new UserM();
        m.setNo(t.getNo());
        m.setNickname(t.getNickname());
        m.setSex(t.getSex().getValue());
        m.setType(t.getType().getValue());
        m.setAdmin(t.isAdmin());

        return m;
    }

    public List<UserM> ConverToUserM (List<UserT> userTList) {
        List<UserM> userMList = new ArrayList<>();

        for (UserT t : userTList) {
            userMList.add(ConverToUserM(t));
        }

        return userMList;
    }
}
