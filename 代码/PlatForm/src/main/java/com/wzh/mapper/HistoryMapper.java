package com.wzh.mapper;

import java.util.ArrayList;

import com.wzh.entity.HistoryPojo;
import com.wzh.entity.MoneyPojo;
import com.wzh.model.Collector;
import com.wzh.model.History;

public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
    
    History selectCurrent();
    
    ArrayList<History> selectWeek();

    ArrayList<History> searchByDesc();

    ArrayList<HistoryPojo> searchByYear();

    ArrayList<MoneyPojo> searchMoney();

}