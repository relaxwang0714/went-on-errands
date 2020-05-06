package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.feign.CustomerFeignClient;
import com.wzh.model.Collector;
import com.wzh.model.History;
import com.wzh.service.SummaryService;

@RestController
@RequestMapping("/summary")
public class SummaryController {
    @Autowired
    private CustomerFeignClient customerFeignClient;
    
    @Autowired
    private SummaryService summaryService;
    
    @GetMapping("/current")
    @Cacheable(value = "summary")
    public History searchCurrent(){
        
        return summaryService.searchCurrent();
    }
    
    @GetMapping("/week")
    @Cacheable(value = "summary")
    public ArrayList<History> searchWeek(){
        
        return summaryService.searchWeek();
    }
    @GetMapping("/collector")
    @Cacheable(value = "summary")
    public ArrayList<Collector> searchCollector(){
        
        return customerFeignClient.searchByDesc();
    }
    
   

}
