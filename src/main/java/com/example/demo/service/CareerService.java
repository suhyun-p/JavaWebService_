package com.example.demo.service;

import com.example.demo.entity.CareerT;
import com.example.demo.enums.CareerType;
import com.example.demo.enums.UserType;
import com.example.demo.model.CareerM;
import com.example.demo.repository.CareerRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CareerService {
    @Autowired
    CareerRepository careerRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public CareerM findCareer(Long userNo) {

        return ConvertToCareerM(userNo, careerRepository.findAllByUserNoEquals(userNo));
    }

    /// region Converter

    private CareerM ConvertToCareerM (Long userNo, List<CareerT> careerTList) {
        CareerM m = new CareerM();
        m.setUserNo(userNo);
        m.setNickname(userRepository.getOne(userNo).getNickname());
        m.setTutor(userRepository.getOne(userNo).getType().equals(UserType.Tutor));

        List<String> profileList = new ArrayList<>(0);
        List<String> awardsList = new ArrayList<>(0);
        List<String> workshopList = new ArrayList<>(0);
        List<String> performanceList = new ArrayList<>(0);
        List<String> classList = new ArrayList<>(0);

        for (CareerT t : careerTList) {
            if(t.getType() == CareerType.Profile) profileList.add(t.getCareer());
            if(t.getType() == CareerType.Awards) awardsList.add(t.getCareer());
            if(t.getType() == CareerType.Workshop) workshopList.add(t.getCareer());
            if(t.getType() == CareerType.Performance) performanceList.add(t.getCareer());
            if(t.getType() == CareerType.Class) classList.add(t.getCareer());
        }

        m.setProfileList(profileList);
        m.setAwardsList(awardsList);
        m.setWorkshopList(workshopList);
        m.setPerformanceList(performanceList);
        m.setClassList(classList);

        return m;
    }
    /// endregion
}


