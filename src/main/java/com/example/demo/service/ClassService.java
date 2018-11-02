package com.example.demo.service;

import com.example.demo.entity.ClassT;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository clsssRepository;

    @Transactional
    public List<ClassT> findClassAll() {
        List<ClassT> classTList = clsssRepository.findAll();

        return classTList;
    }
}
