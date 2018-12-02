package com.wzh.service;

import java.util.ArrayList;

import com.wzh.model.Business;

public interface PaotuiService {
    int insert(Business business);

    int ditance(String type, String start, String finish);
    ArrayList<Business> searchBySatatus(Long userid, int status);

}
