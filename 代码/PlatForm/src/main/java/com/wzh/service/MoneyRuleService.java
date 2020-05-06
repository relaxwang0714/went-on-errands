package com.wzh.service;

import java.util.ArrayList;

import com.wzh.model.Moneyrule;

public interface MoneyRuleService {
    
     int insert(ArrayList<Moneyrule> moneylist);



    int searchByType(String type, int distance);
}
