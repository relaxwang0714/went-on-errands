package com.wzh.service;

import java.util.ArrayList;

import com.wzh.model.Collector;
import com.wzh.model.History;

public interface SummaryService {
    History searchCurrent();

    ArrayList<History> searchWeek();


}
