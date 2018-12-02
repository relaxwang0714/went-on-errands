package com.wzh.model;

import java.util.ArrayList;

public class AddressCode {
    private int status;
    private String info;
    private int infocode;
    private int count;
    private ArrayList<CodeDetail> geocodes;
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
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public ArrayList<CodeDetail> getGeocodes() {
        return geocodes;
    }
    public void setGeocodes(ArrayList<CodeDetail> geocodes) {
        this.geocodes = geocodes;
    }
    
    

}

    
    
