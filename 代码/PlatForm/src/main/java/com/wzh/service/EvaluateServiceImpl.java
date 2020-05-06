package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.entity.EvaluatePojo;
import com.wzh.mapper.EvaluateMapper;
import com.wzh.model.Evaluate;
@Service
public class EvaluateServiceImpl implements EvaluateService{
    @Autowired
    private EvaluateMapper evaluatemapper;

    @Override
    public ArrayList<Evaluate> searchbyuserid(Long userid) {
        // TODO Auto-generated method stub
        return evaluatemapper.selectByUserId(userid);
    }

    @Override
    public int repeat(Evaluate evaluate) {
        // TODO Auto-generated method stub
        return evaluatemapper.updateByPrimaryKeySelective(evaluate);
    }

    @Override
    public int insert(Evaluate evaluate) {
        // TODO Auto-generated method stub
        return evaluatemapper.insertSelective(evaluate);
    }

    @Override
    public ArrayList<Evaluate> searchall() {
        // TODO Auto-generated method stub
        return evaluatemapper.searchAll();
    }

    @Override
    public ArrayList<Evaluate> search(EvaluatePojo evaluatepojo) {
        // TODO Auto-generated method stub
        return evaluatemapper.search(evaluatepojo);
    }

    @Override
    public int repeat(Long id,String repeat) {
        // TODO Auto-generated method stub
        Evaluate evaluate = new Evaluate();
        evaluate.setId(id);
        evaluate.setRepeat(repeat);
        return evaluatemapper.updateByPrimaryKey(evaluate);
    }
    

}
