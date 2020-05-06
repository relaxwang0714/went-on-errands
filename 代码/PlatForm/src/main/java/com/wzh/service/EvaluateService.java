package com.wzh.service;

import java.util.ArrayList;

import com.wzh.entity.EvaluatePojo;
import com.wzh.model.Evaluate;

public interface EvaluateService {
    
    ArrayList<Evaluate> searchall();
    ArrayList<Evaluate> searchbyuserid(Long userid);
    int repeat(Evaluate evaluate);
    int insert(Evaluate evaluate);
    ArrayList<Evaluate> search(EvaluatePojo evaluatepojo);
    int repeat(Long id, String repeat);

}
