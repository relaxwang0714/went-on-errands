package com.wzh.mapper;

import java.util.ArrayList;

import com.wzh.entity.BusinessPojo;
import com.wzh.model.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKeyWithBLOBs(Business record);

    int updateByPrimaryKey(Business record);
    
    ArrayList<Business> searchAll();
    
    ArrayList<Business> needAll();
    
    ArrayList<Business> selectByPrimaryKeySelective(Business record);

    ArrayList<Business> searchPojo(BusinessPojo businessPojo);
}