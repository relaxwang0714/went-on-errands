package com.wzh.service;

import java.util.ArrayList;

import com.wzh.entity.BusinessPojo;
import com.wzh.model.Business;


public interface BusinessService {
    ArrayList<Business> searchAll();
    
    ArrayList<Business> needAll();
    
    Business findById(Long id);
    
    int jiedan(Business business);
    
    ArrayList<Business> searchBystatus(Business busienss);
    
    int insert(Business business);
    
    ArrayList<Business> searchBySelect(Business business);
    

    ArrayList<Business> searchPojo(BusinessPojo businessPojo);
    

}
