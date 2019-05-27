package com.yootk.drp.vo;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private Long oid;
    private String mid;
    private Integer adid;
    private Date subdata;
    private Double price;
    private String text;

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", mid='" + mid + '\'' +
                ", adid=" + adid +
                ", subdata=" + subdata +
                ", price=" + price +
                ", text='" + text + '\'' +
                '}';
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Date getSubdata() {
        return subdata;
    }

    public void setSubdata(Date subdata) {
        this.subdata = subdata;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

