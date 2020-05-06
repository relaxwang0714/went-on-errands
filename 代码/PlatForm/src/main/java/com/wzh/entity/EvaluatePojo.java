package com.wzh.entity;

public class EvaluatePojo {
    private int userId;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    private int collectorId;
    private String time1;
    private String time2;
    public int getCollectorId() {
        return collectorId;
    }
    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }
    public String getTime1() {
        return time1;
    }
    public void setTime1(String time1) {
        this.time1 = time1;
    }
    public String getTime2() {
        return time2;
    }
    public void setTime2(String time2) {
        this.time2 = time2;
    }

}
