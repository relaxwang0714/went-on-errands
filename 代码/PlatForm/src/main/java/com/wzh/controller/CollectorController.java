package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.model.Collector;
import com.wzh.service.CollectorService;

@RestController
@RequestMapping("/collector")
public class CollectorController {
    @Autowired
    private CollectorService collectorService;
    
    @PostMapping("insert")
    public int insert(@RequestBody Collector collector){
        
        return collectorService.insert(collector);
    }
    
    @GetMapping("delete/{id}")
    public int delete(@PathVariable Integer id){
        
        return collectorService.delete(id);
    }
    @Cacheable(value = "collector")
    @PostMapping("search")
    public ArrayList<Collector> searchSelect(@RequestBody Collector collector){
        
        return collectorService.searchSelect(collector);
    }
    
    @GetMapping("search/{id}")
    public Collector searchById(@PathVariable Integer id ){
        
        return collectorService.search(id);
    }
    
    @PostMapping("update")
    public int update(@RequestBody Collector collector){
        
        return collectorService.update(collector);
    }
    @Cacheable(value = "collector")
    @GetMapping("searchbydesc")
    public ArrayList<Collector> searchByDesc(){
        
        return collectorService.searchByDesc();
    }
    

}
