package com.wzh.service;

import java.util.ArrayList;

import com.wzh.model.Business;

public interface PeisongService {
    ArrayList<Business> waitAll();
    Business findById(Long id);
    int jiedan(Long collectorid,Long id);
    ArrayList<Business> searchByStatus(Long collectorid,Long id);


}
