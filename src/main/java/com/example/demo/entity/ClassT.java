package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "class")
public class ClassT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", nullable = false)
    private Long no;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "tutor1", nullable = false)
    private Long tutor1;

    @Column(name = "tutor2")
    private Long tutor2;

    @Column(name = "room")
    private String room;

    @Column(name = "payment")
    private String payment;

    @Column(name = "contact")
    private String contact;

    @OneToMany(targetEntity = CurriculumT.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_no")
    private List<CurriculumT> curriculums;

    @OneToMany(targetEntity = DateOptionT.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_no")
    private List<DateOptionT> dateOptionList;

    @OneToMany(targetEntity = PriceOptionT.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_no")
    private List<PriceOptionT> priceOptionList;
}
