package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.mapper.MoneyruleMapper;
import com.wzh.model.Moneyrule;

@Service
public class MoneyRuleServcieImpl implements MoneyRuleService {
    @Autowired
    private MoneyruleMapper moneyRuleMapper;

    @Override
    public int insert(ArrayList<Moneyrule> moneylist) {
        // TODO Auto-generated method stub
        return moneyRuleMapper.insertlist(moneylist);
    }

    @Override
    public int searchByType(String type, int distance) {
        // TODO Auto-generated method stub
        return moneyRuleMapper.selectByType(type,distance);
    }



}
