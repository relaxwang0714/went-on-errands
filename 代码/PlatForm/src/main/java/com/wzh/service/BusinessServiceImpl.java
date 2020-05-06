package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.entity.BusinessPojo;
import com.wzh.mapper.BusinessMapper;
import com.wzh.model.Business;
@Service
public class BusinessServiceImpl implements BusinessService{
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public ArrayList<Business> searchAll() {
        // TODO Auto-generated method stub
        return businessMapper.searchAll();
    }

    @Override
    public ArrayList<Business> needAll() {
        // TODO Auto-generated method stub
        return businessMapper.needAll();
    }

    @Override
    public Business findById(Long id) {
        // TODO Auto-generated method stub
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public int jiedan(Business business) {
        // TODO Auto-generated method stub
        businessMapper.updateByPrimaryKeySelective(business);
        return 0;
    }

    @Override
    public ArrayList<Business> searchBystatus(Business business) {
        // TODO Auto-generated method stub
        return businessMapper.selectByPrimaryKeySelective(business);
    }

    @Override
    public int insert(Business business) {
        // TODO Auto-generated method stub
        return businessMapper.insertSelective(business);
    }

    @Override
    public ArrayList<Business> searchBySelect(Business business) {
        // TODO Auto-generated method stub
        return businessMapper.selectByPrimaryKeySelective(business);
    }

    @Override
    public ArrayList<Business> searchPojo(BusinessPojo businessPojo) {
        // TODO Auto-generated method stub
        return businessMapper.searchPojo(businessPojo);
    }

}
