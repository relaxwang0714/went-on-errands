package com.wzh.mapper;

import java.util.ArrayList;

import com.wzh.entity.EvaluatePojo;
import com.wzh.model.Evaluate;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    ArrayList<Evaluate> selectByUserId(Long userid);

    ArrayList<Evaluate> searchAll();

    ArrayList<Evaluate> search(EvaluatePojo evaluatepojo);

}