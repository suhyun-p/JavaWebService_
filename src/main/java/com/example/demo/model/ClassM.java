package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassM {
    private Long no;
    private String title;
    private Long tutorNo1;
    private Long tutorNo2;
    private String tutorName1;
    private String tutorName2;

    public ClassM() {

    }

    public ClassM (Long no, String title, Long tutorNo1, Long tutorNo2, String tutorName1, String tutorName2) {
        this.no = no;
        this.title = title;
        this.tutorNo1 = tutorNo1;
        this.tutorNo2 = tutorNo2;
        this.tutorName1 = tutorName1;
        this.tutorName2 = tutorName2;
    }
}
