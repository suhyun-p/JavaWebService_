package com.example.demo.model;

import com.example.demo.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SchoolM {
    private Long schoolNo;
    private String schoolName;
    private List<String> studentList;

    public SchoolM(Long schoolNo, String schoolName){
        this.schoolNo = schoolNo;
        this.schoolName = schoolName;
    }

    public SchoolM(Long schoolNo, String schoolName, List<StudentEntity> studentList){
        this.schoolNo = schoolNo;
        this.schoolName = schoolName;

        if(this.studentList == null) this.studentList = new ArrayList<String>();
        for (StudentEntity s: studentList) {
            this.studentList.add(s.getStudentName());
        }
    }
}
