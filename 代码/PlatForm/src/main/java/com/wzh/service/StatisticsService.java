package com.wzh.service;

import java.util.ArrayList;

import com.wzh.entity.HistoryPojo;
import com.wzh.entity.MoneyPojo;
import com.wzh.model.Collector;
import com.wzh.model.Flow;
import com.wzh.model.History;

public interface StatisticsService {
    ArrayList<History> Todaysurvey();

    ArrayList<History> searchByDesc();

    ArrayList<HistoryPojo> searchByYear();

    ArrayList<MoneyPojo> searchMoney();

    Flow searchFlow();

    ArrayList<History> searchMoneyByWeek();
    

}
