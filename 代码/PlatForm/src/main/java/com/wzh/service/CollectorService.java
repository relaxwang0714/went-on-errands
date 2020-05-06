package com.wzh.service;

import java.util.ArrayList;

import com.wzh.model.Collector;

public interface CollectorService {
    
    int insert(Collector collector);
    
    int update(Collector collector);
    
    int delete(int id);

    Collector search(int id);

    ArrayList<Collector> searchSelect(Collector collector);

    ArrayList<Collector> searchByDesc();

}
