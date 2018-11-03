package com.example.demo.converter;

import com.example.demo.entity.ClassT;
import com.example.demo.model.ClassM;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

final public class ClassConverter {

    @Autowired
    UserRepository userRepository;

    public ClassM ConvertToClassM (ClassT t) {
        ClassM m = new ClassM();
        m.setNo(t.getNo());
        m.setTitle(t.getTitle());
        m.setTutorNo1(t.getTutor1());
        m.setTutorNo2(t.getTutor2());

        if(userRepository == null) System.out.println("null");

        return m;
    }

    public List<ClassM> ConvertToClassM (List<ClassT> classTList) {
        List<ClassM> classMList = new ArrayList<>();

        for (ClassT t : classTList) {
            classMList.add(ConvertToClassM(t));
        }

        return classMList;
    }
}
