package com.wzh.model;

public class DistanceReturn {
    private int origin_id;
    private int dest_id;
    private int distance;
    private int duration;
    public int getOrigin_id() {
        return origin_id;
    }
    public void setOrigin_id(int origin_id) {
        this.origin_id = origin_id;
    }
    public int getDest_id() {
        return dest_id;
    }
    public void setDest_id(int dest_id) {
        this.dest_id = dest_id;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
