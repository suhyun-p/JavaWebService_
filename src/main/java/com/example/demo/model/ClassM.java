package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassM {
    private Long no;
    private String title;
    private Long tutorNo1;
    private String tutorName1;
    private Long tutorNo2;
    private String tutorName2;
    private String room;
    private String payment;
    private String contact;
    private List<String> curriculums;
    private List<String> dateOptionList;
    private List<String> priceOptionList;

    public ClassM() {

    }
}
