package com.example.demo.service;

import com.example.demo.converter.ClassConverter;
import com.example.demo.entity.ClassT;
import com.example.demo.model.ClassM;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;

    @Transactional
    public List<ClassM> findClassAll() {

        return new ClassConverter().ConvertToClassM(classRepository.findAll());
    }
}
