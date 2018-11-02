package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassM {
    private Long no;
    private String title;
    private Long tutor1;
    private Long tutor2;

    public ClassM (Long no, String title, Long tutor1, Long tutor2) {
        this.no = no;
        this.title = title;
        this.tutor1 = tutor1;
        this.tutor2 = tutor2;
    }
}
