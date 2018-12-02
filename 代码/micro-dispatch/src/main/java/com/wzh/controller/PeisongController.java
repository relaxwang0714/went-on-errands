package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.model.Business;
import com.wzh.service.PeisongService;

@RestController
@RequestMapping("/peisong")
public class PeisongController {
    @Autowired
    private PeisongService peisongService;
    
    @GetMapping("waitall")
    public ArrayList<Business> waitAll(){
        return peisongService.waitAll();
    }
    @GetMapping("findbyid/{id}")
    public Business findById(@PathVariable Long id){
        return peisongService.findById(id);
        
    }
//    @GetMapping("jiedan/{collectorid}")
//    public ArrayList<Business> searchByCollector(@PathVariable(value="collectorid") Long collectorid){
////        Business ab  = new Business();
////        ab.setCollectorId(collectorid);
//        
//        return peisongService.searchByCollector(collectorid);
//        
//    }
    @GetMapping("jiedan/{collectorid}/{id}")
    public int jiedan(@PathVariable(value="collectorid") Long collectorid,@PathVariable(value="id") Long id){
        return peisongService.jiedan(collectorid,id);
        
    }
    @GetMapping("searchbystatus/{collectorid}/{status}")
    public ArrayList<Business> searchbyStatus(@PathVariable(value="collectorid") Long collectorid,@PathVariable(value="status") Long status){
        return peisongService.searchByStatus(collectorid, status);
        
    }

}
