package com.wzh.model;

import java.io.Serializable;

/**
 * pic
 * @author 
 */
public class Pic implements Serializable {
    private Integer id;

    private String picturepath;

    private String brief;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}