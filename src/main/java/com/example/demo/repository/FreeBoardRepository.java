package com.example.demo.repository;

import com.example.demo.model.FreeBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardRepository {
    private static final String MAPPER_NAME_SPACE="sample.mapper.freeBoardMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void registBoard(FreeBoardVO freeBoardVO){
        System.out.println("UserName  : " + freeBoardVO.getUserName());
        System.out.println("Category  : " + freeBoardVO.getCategory());
        System.out.println("Title  : " + freeBoardVO.getTitle());
        System.out.println("Content  : " + freeBoardVO.getContent());

        sqlSessionTemplate.insert(MAPPER_NAME_SPACE+ "insertBoard", freeBoardVO);
    }
}
