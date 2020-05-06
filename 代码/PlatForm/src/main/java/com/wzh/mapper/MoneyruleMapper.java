package com.wzh.mapper;

import java.util.ArrayList;

import com.wzh.model.Moneyrule;

public interface MoneyruleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Moneyrule record);

    int insertSelective(Moneyrule record);

    Moneyrule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Moneyrule record);

    int updateByPrimaryKey(Moneyrule record);

    int insertlist(ArrayList<Moneyrule> moneylist);

    int selectByType(String type, int distance);


    
    
}