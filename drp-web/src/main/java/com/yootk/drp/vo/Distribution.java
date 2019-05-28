package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * 出库申请表
 * @author yaoxinlan
 */
public class Distribution implements Serializable {
    private Integer dsid;
    private String title;
    private Integer pid;
    private Integer cid;
    private Integer gnum;
    private Double price;
    private Integer status;
    private String note;

    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "dsid=" + dsid +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", gnum=" + gnum +
                ", price=" + price +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }
}
