package com.example.demo.service;

import com.example.demo.entity.CareerT;
import com.example.demo.model.CareerM;
import com.example.demo.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CareerService {
    @Autowired
    CareerRepository careerRepository;

    @Transactional
    public List<CareerM> findTutorCareer(Long tutorNo) {

        return ConvertToCareerM(careerRepository.findAllByUserNoEquals(tutorNo));
    }

    /// region Converter

    private CareerM ConvertToCareerM (CareerT t) {
        CareerM m = new CareerM();
        m.setNo(t.getNo());
        m.setUserNo(t.getUserNo());
        m.setType(t.getType());
        m.setCareer(t.getCareer());

        return m;
    }

    private List<CareerM> ConvertToCareerM (List<CareerT> tutorCareerTList) {
        List<CareerM> tutorCareerMList = new ArrayList<>();

        for (CareerT t : tutorCareerTList) {
            tutorCareerMList.add(ConvertToCareerM(t));
        }

        return tutorCareerMList;
    }
    /// endregion
}


