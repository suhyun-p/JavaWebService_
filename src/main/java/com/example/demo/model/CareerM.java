package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CareerM {
    private Long userNo;
    private String nickname;
    private List<String> profileList;
    private List<String> awardsList;
    private List<String> workshopList;
    private List<String> performanceList;
    private List<String> classList;

    public CareerM() {

    }
}
