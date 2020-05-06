package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.model.Moneyrule;
import com.wzh.service.MoneyRuleService;



@RestController
@RequestMapping("/moneyrole")
public class MoneyRoleController {
    @Autowired
    private MoneyRuleService moneyRuleService;
    @PostMapping("/insert")
    public int insert(@RequestBody ArrayList<Moneyrule> moneylist){
        return moneyRuleService.insert(moneylist);
        
    }
    @GetMapping("/searchbytype/{type}/{distance}")
    public int searchByType(@PathVariable(value="type") String type,@PathVariable(value="distance") int distance){
        return moneyRuleService.searchByType(type,distance);
        
    }

}
