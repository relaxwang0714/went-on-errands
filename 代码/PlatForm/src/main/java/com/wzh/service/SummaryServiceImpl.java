package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.mapper.HistoryMapper;
import com.wzh.model.Collector;
import com.wzh.model.History;

@Service
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public History searchCurrent() {
        // TODO Auto-generated method stub
        return historyMapper.selectCurrent();
    }

    @Override
    public ArrayList<History> searchWeek() {
        // TODO Auto-generated method stub
        return historyMapper.selectWeek();
    }



}
