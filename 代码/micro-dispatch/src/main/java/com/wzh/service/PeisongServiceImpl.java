package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.feign.BusinessFeign;
import com.wzh.model.Business;
@Service
public class PeisongServiceImpl implements PeisongService {
    @Autowired
    private BusinessFeign businessFeign;

    @Override
    public ArrayList<Business> waitAll() {
        // TODO Auto-generated method stub
        return businessFeign.waitAll();
    }

    @Override
    public Business findById(Long id) {
        // TODO Auto-generated method stub
        return businessFeign.findById(id);
    }

    @Override
    public int jiedan(Long collectorid,Long id) {
        // TODO Auto-generated method stub

        return businessFeign.jiedan(collectorid,id);
    }

    @Override
    public ArrayList<Business> searchByStatus(Long collectorid, Long id) {
        // TODO Auto-generated method stub
        return businessFeign.searchByStatus(collectorid, id);
    }



}
