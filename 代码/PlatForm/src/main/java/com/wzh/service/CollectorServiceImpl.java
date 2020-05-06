package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.mapper.CollectorMapper;
import com.wzh.model.Collector;

@Service
public class CollectorServiceImpl implements CollectorService{
    @Autowired
    private CollectorMapper collectorMapper;

    @Override
    public int insert(Collector collector) {
        // TODO Auto-generated method stub
        return collectorMapper.insert(collector);
    }

    @Override
    public int update(Collector collector) {
        // TODO Auto-generated method stub
        return collectorMapper.updateByPrimaryKeySelective(collector);
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        return collectorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Collector search(int id) {
        // TODO Auto-generated method stub
        return collectorMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArrayList<Collector> searchSelect(Collector collector) {
        // TODO Auto-generated method stub
        return collectorMapper.searchAll(collector);
    }

    @Override
    public ArrayList<Collector> searchByDesc() {
        // TODO Auto-generated method stub
        return collectorMapper.searchByDesc();
    }



  

}
