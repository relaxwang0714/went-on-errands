package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.entity.HistoryPojo;
import com.wzh.entity.MoneyPojo;
import com.wzh.model.Collector;
import com.wzh.model.Flow;
import com.wzh.model.History;
import com.wzh.service.StatisticsService;

@RestController
@RequestMapping("statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    
    @GetMapping("/desc")

    public ArrayList<History> searchByDesc(){
        
        return statisticsService.searchByDesc();
    }
    @GetMapping("/year")
  //  @Cacheable(value = "statistics")
    public ArrayList<HistoryPojo> searchByYear(){
        
        return statisticsService.searchByYear();
    }
    @GetMapping("/money")
    public ArrayList<MoneyPojo> searchMoney(){
        
        return statisticsService.searchMoney();
    }
    @GetMapping("/week")
    public ArrayList<History> searchMoneyByWeek(){
        
        return statisticsService.searchMoneyByWeek();
    }
    
    @GetMapping("/flow")
    public Flow searchFlow(){
        
        return statisticsService.searchFlow();
    }

}
