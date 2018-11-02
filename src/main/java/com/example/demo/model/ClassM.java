package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassM {
    private Long no;
    private String title;
    private String tutor1;
    private String tutor2;

    public ClassM() {

    }

    public ClassM (Long no, String title, String tutor1, String tutor2) {
        this.no = no;
        this.title = title;
        this.tutor1 = tutor1;
        this.tutor2 = tutor2;
    }
}
