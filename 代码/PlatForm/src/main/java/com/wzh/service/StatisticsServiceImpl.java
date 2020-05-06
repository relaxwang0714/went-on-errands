package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.entity.HistoryPojo;
import com.wzh.entity.MoneyPojo;
import com.wzh.mapper.HistoryMapper;
import com.wzh.model.Flow;
import com.wzh.model.History;
import com.wzh.mapper.CityMapper;
import com.wzh.mapper.FlowMapper;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private FlowMapper flowMapper;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public ArrayList<History> Todaysurvey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<History> searchByDesc() {
        // TODO Auto-generated method stub
        return historyMapper.searchByDesc();
    }

    @Override
    public ArrayList<HistoryPojo> searchByYear() {
        // TODO Auto-generated method stub
        return historyMapper.searchByYear();
    }

    @Override
    public ArrayList<MoneyPojo> searchMoney() {
        // TODO Auto-generated method stub
        return historyMapper.searchMoney();
    }

    @Override
    public Flow searchFlow() {
        // TODO Auto-generated method stub
        return flowMapper.searchfirst();
    }

    @Override
    public ArrayList<History> searchMoneyByWeek() {
        // TODO Auto-generated method stub
        return historyMapper.selectWeek();
    }

}
