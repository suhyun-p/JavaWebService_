package com.example.demo.service;

import com.example.demo.entity.ClassT;
import com.example.demo.model.ClassM;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository clsssRepository;

    @Transactional
    public List<ClassM> findClassAll() {
        List<ClassT> classTList = clsssRepository.findAll();
        List<ClassM> classMList = new ArrayList<>();

        for(ClassT t : classTList) {
            classMList.add(new ClassM(t.getNo(), t.getTitle(), t.getTutor1(), t.getTutor2()));
        }

        return classMList;
    }
}
