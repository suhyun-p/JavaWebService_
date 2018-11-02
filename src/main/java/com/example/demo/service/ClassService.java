package com.example.demo.service;

import com.example.demo.entity.ClassT;
import com.example.demo.model.ClassM;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<ClassM> findClassAll() {
        List<ClassT> classTList = classRepository.findAll();
        List<ClassM> classMList = new ArrayList<>();

        for(ClassT t : classTList) {
            ClassM classM = new ClassM();
            classM.setNo(t.getNo());
            classM.setTitle(t.getTitle());
            classM.setTutor1(userRepository.getOne(t.getTutor1()).getNickname());

            if(t.getTutor2() != null)
                classM.setTutor2(userRepository.getOne(t.getTutor2()).getNickname());
            else
                classM.setTutor2("");

            classMList.add(classM);
        }

        return classMList;
    }
}
