package com.wzh.model;

import java.util.ArrayList;

public class Geocoder {
    private int status;
    private String info;
    private int infocode;
    private ArrayList<DistanceReturn> results;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public int getInfocode() {
        return infocode;
    }
    public void setInfocode(int infocode) {
        this.infocode = infocode;
    }
    public ArrayList<DistanceReturn> getResults() {
        return results;
    }
    public void setResults(ArrayList<DistanceReturn> results) {
        this.results = results;
    }
  
    
}
