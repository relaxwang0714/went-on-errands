package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.entity.EvaluatePojo;
import com.wzh.model.Evaluate;
import com.wzh.service.CustomerService;
import com.wzh.service.EvaluateService;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;
    
//    @GetMapping("/searchbyid/{userid}")
//    public ArrayList<Evaluate> searchbyid(@PathVariable Long userid) {
//        return evaluateService.searchbyuserid(userid);
//    }
    @PostMapping("/search")
    public ArrayList<Evaluate> search(@RequestBody EvaluatePojo evaluatepojo){
        return evaluateService.search(evaluatepojo);
        
    }
    @GetMapping("/repeat/{id}/{repeat}")
    public int repeat(@PathVariable Long id,@PathVariable String repeat){
        return evaluateService.repeat(id,repeat);
        
    }
    
    
    @GetMapping("/searchbyid/{userid}")
    public ArrayList<Evaluate> searchbyid(@PathVariable Long userid) {
        return evaluateService.searchbyuserid(userid);
    }
    @GetMapping("/repeat/{id}/{content}")
    public int repead(@PathVariable(value="id") Long id,@PathVariable(value="content") String content) {
        Evaluate evaluate =new Evaluate();
        evaluate.setId(id);
        evaluate.setRepeat(content);
        return evaluateService.repeat(evaluate);
    }
    @PostMapping("/insert")
    public int insert(@RequestBody Evaluate evaluate ) {

        return evaluateService.insert(evaluate);
    }

}
