package com.example.demo.repository;

import com.example.demo.model.FreeBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreeBoardRepository {
    private static final String MAPPER_NAME_SPACE="sample.mapper.freeBoardMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void registBoard(FreeBoardVO freeBoardVO){
        sqlSessionTemplate.insert(MAPPER_NAME_SPACE+ "insertBoard", freeBoardVO);
    }

    public List<FreeBoardVO> getBoardList() {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectBoardList");
    }
}
