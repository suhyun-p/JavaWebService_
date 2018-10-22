package com.example.demo.service;

import com.example.demo.entity.SchoolEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.SchoolM;
import com.example.demo.model.StudentM;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void initData() {
        SchoolEntity sc1 = new SchoolEntity("매력고");
        schoolRepository.save(sc1);

        SchoolEntity sc2 = new SchoolEntity("예체능고");
        schoolRepository.save(sc2);

        StudentEntity stu1 = new StudentEntity("나라");
        StudentEntity stu2 = new StudentEntity("민하");
        StudentEntity stu3 = new StudentEntity("나나");

        StudentEntity stu4 = new StudentEntity("홍길동");
        StudentEntity stu5 = new StudentEntity("유재석");

        stu1.setSchool(sc1);
        stu2.setSchool(sc1);
        stu3.setSchool(sc1);

        stu4.setSchool(sc2);
        stu5.setSchool(sc2);

        studentRepository.save(stu1);
        studentRepository.save(stu2);
        studentRepository.save(stu3);
        studentRepository.save(stu4);
        studentRepository.save(stu5);
    }

    @Transactional
    public List<StudentM> findStudentInfo() {
        List<StudentM> response = new ArrayList<>();

        List<StudentEntity> students = studentRepository.findAll();
        for (StudentEntity s : students) {
            response.add(new StudentM(s.getUserName(), "", s.getSchool().getName()));
            // System.out.println(s.getUserName() + ", " + s.getSchool().getName());
        }

        return response;
    }

    @Transactional
    public List<SchoolM> findSchoolInfo() {
        List<SchoolM> response = new ArrayList<>();

        List<SchoolEntity> schools = schoolRepository.findAll();
        for (SchoolEntity s : schools) {
            response.add(new SchoolM(s.getName(), s.getStudents()));
            // System.out.println(s.toString());
        }

        return response;
    }
}