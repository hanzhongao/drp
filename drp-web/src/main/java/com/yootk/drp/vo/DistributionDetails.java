package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * 出库申请详情表
 * @author yaoxinlan
 */
public class DistributionDetails implements Serializable {
    private Integer dsdid;
    private Integer gid;
    private String name;
    private Integer num;
    private Double price;
    private Integer status;
    private Integer wid;
    private String outmid;

    public Integer getDsdid() {
        return dsdid;
    }

    public void setDsdid(Integer dsdid) {
        this.dsdid = dsdid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getOutmid() {
        return outmid;
    }

    public void setOutmid(String outmid) {
        this.outmid = outmid;
    }

    @Override
    public String toString() {
        return "DistributionDetails{" +
                "dsdid=" + dsdid +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", status=" + status +
                ", wid=" + wid +
                ", outmid='" + outmid + '\'' +
                '}';
    }
}
