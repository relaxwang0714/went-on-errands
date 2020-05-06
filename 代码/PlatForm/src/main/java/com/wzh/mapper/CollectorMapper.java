package com.wzh.mapper;

import java.util.ArrayList;

import com.wzh.model.Collector;

public interface CollectorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collector record);

    int insertSelective(Collector record);

    Collector selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collector record);

    int updateByPrimaryKey(Collector record);
    
    ArrayList<Collector> searchAll(Collector collector);

    ArrayList<Collector> searchByDesc();
}