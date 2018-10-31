package com.example.demo.service;

import com.example.demo.entity.SchoolEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.SchoolM;
import com.example.demo.model.StudentM;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    /// region StudentInfo
    @Transactional
    public List<StudentM> findStudentInfo() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentM> studentMList = new ArrayList<StudentM>();

        for (StudentEntity s : studentEntityList) {
            studentMList.add(new StudentM(s.getStudentNo(), s.getStudentName(), s.getSchool().getSchoolName()));
        }

        return studentMList;
    }
    /// endregion

    /// region SchoolInfo
    @Transactional
    public List<SchoolM> findSchoolInfo() {
        List<SchoolEntity> schoolEntityList = schoolRepository.findAll();
        List<SchoolM> schoolMList = new ArrayList<SchoolM>();

        for (SchoolEntity s : schoolEntityList) {
            schoolMList.add(new SchoolM(s.getSchoolNo(), s.getSchoolName(), s.getStudents()));
        }

        return schoolMList;
    }

    public List<SchoolM> findSchoolNameList() {
        List<SchoolEntity> schoolEntityList = schoolRepository.findAll();
        List<SchoolM> schoolMList = new ArrayList<SchoolM>();

        for (SchoolEntity s : schoolEntityList) {
            schoolMList.add(new SchoolM(s.getSchoolNo(), s.getSchoolName()));
        }

        return schoolMList;
    }

    @Transactional
    public String addSchool(String schoolName) {
        SchoolEntity school = new SchoolEntity();
        school.setSchoolName(schoolName);

        schoolRepository.save(school);

        return "OK";
    }
    /// endregion
}
