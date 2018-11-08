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
    public ClassM findClass(Long classNo) {

        return ConvertToClassM(classRepository.getOne(classNo));
    }

    @Transactional
    public List<ClassM> findClassAll() {

        return ConvertToClassM(classRepository.findAll());
    }

    /// region Converter

    private ClassM ConvertToClassM (ClassT t) {
        ClassM m = new ClassM();
        m.setNo(t.getNo());
        m.setTitle(t.getTitle());
        m.setTutorNo1(t.getTutor1());
        m.setTutorName1(userRepository.getOne(t.getTutor1()).getNickname());
        m.setTutorNo2(t.getTutor2());
        m.setTutorName2(t.getTutor2() == null ? "" : userRepository.getOne(t.getTutor2()).getNickname());

        return m;
    }

    private List<ClassM> ConvertToClassM (List<ClassT> classTList) {
        List<ClassM> classMList = new ArrayList<>();

        for (ClassT t : classTList) {
            classMList.add(ConvertToClassM(t));
        }

        return classMList;
    }
    /// endregion
}
