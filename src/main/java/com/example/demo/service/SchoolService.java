package com.example.demo.service;

import com.example.demo.entity.SchoolT;
import com.example.demo.entity.StudentT;
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
        SchoolT sc1 = new SchoolT("매력고");
        schoolRepository.save(sc1);

        SchoolT sc2 = new SchoolT("예체능고");
        schoolRepository.save(sc2);

        StudentT stu1 = new StudentT("나라");
        StudentT stu2 = new StudentT("민하");
        StudentT stu3 = new StudentT("나나");

        StudentT stu4 = new StudentT("홍길동");
        StudentT stu5 = new StudentT("유재석");

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

        List<StudentT> students = studentRepository.findAll();
        for (StudentT s : students) {
            response.add(new StudentM(s.getUserName(), "", s.getSchool().getName()));
            // System.out.println(s.getUserName() + ", " + s.getSchool().getName());
        }

        return response;
    }

    @Transactional
    public List<SchoolM> findSchoolInfo() {
        List<SchoolM> response = new ArrayList<>();

        List<SchoolT> schools = schoolRepository.findAll();
        for (SchoolT s : schools) {
            response.add(new SchoolM(s.getName(), s.getStudents()));
            // System.out.println(s.toString());
        }

        return response;
    }
}