package com.wzh.model;

import java.io.Serializable;
import java.util.Date;

/**
 * flow
 * @author 
 */
public class Flow implements Serializable {
    private Integer id;

    private Integer pv;

    private Integer uv;

    private Integer ip;

    private Integer share;

    private Integer customerPv;

    private Integer collectorPv;

    private Integer avgPv;

    private String gmtCreate;

    private String gmtModified;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getIp() {
        return ip;
    }

    public void setIp(Integer ip) {
        this.ip = ip;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getCustomerPv() {
        return customerPv;
    }

    public void setCustomerPv(Integer customerPv) {
        this.customerPv = customerPv;
    }

    public Integer getCollectorPv() {
        return collectorPv;
    }

    public void setCollectorPv(Integer collectorPv) {
        this.collectorPv = collectorPv;
    }

    public Integer getAvgPv() {
        return avgPv;
    }

    public void setAvgPv(Integer avgPv) {
        this.avgPv = avgPv;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Flow other = (Flow) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPv() == null ? other.getPv() == null : this.getPv().equals(other.getPv()))
            && (this.getUv() == null ? other.getUv() == null : this.getUv().equals(other.getUv()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getShare() == null ? other.getShare() == null : this.getShare().equals(other.getShare()))
            && (this.getCustomerPv() == null ? other.getCustomerPv() == null : this.getCustomerPv().equals(other.getCustomerPv()))
            && (this.getCollectorPv() == null ? other.getCollectorPv() == null : this.getCollectorPv().equals(other.getCollectorPv()))
            && (this.getAvgPv() == null ? other.getAvgPv() == null : this.getAvgPv().equals(other.getAvgPv()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPv() == null) ? 0 : getPv().hashCode());
        result = prime * result + ((getUv() == null) ? 0 : getUv().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getShare() == null) ? 0 : getShare().hashCode());
        result = prime * result + ((getCustomerPv() == null) ? 0 : getCustomerPv().hashCode());
        result = prime * result + ((getCollectorPv() == null) ? 0 : getCollectorPv().hashCode());
        result = prime * result + ((getAvgPv() == null) ? 0 : getAvgPv().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pv=").append(pv);
        sb.append(", uv=").append(uv);
        sb.append(", ip=").append(ip);
        sb.append(", share=").append(share);
        sb.append(", customerPv=").append(customerPv);
        sb.append(", collectorPv=").append(collectorPv);
        sb.append(", avgPv=").append(avgPv);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}