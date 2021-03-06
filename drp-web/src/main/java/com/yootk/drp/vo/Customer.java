package com.yootk.drp.vo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Long auto_increment;
    private String mid ;
    private String name;
    private String phone;
    private Long pid;
    private Long cid;
    private String address;
    private Date indate;
    private Integer connum;
    private Long ciid;
    private Long csid;
    private String note;
    private String recorder;
    private Integer status;
    private Integer type;

    public Customer() {
    }

    public Long getAuto_increment() {
        return auto_increment;
    }

    public void setAuto_increment(Long auto_increment) {
        this.auto_increment = auto_increment;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Integer getConnum() {
        return connum;
    }

    public void setConnum(Integer connum) {
        this.connum = connum;
    }

    public Long getCiid() {
        return ciid;
    }

    public void setCiid(Long ciid) {
        this.ciid = ciid;
    }

    public Long getCsid() {
        return csid;
    }

    public void setCsid(Long csid) {
        this.csid = csid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "auto_increment=" + auto_increment +
                ", mid='" + mid + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", address='" + address + '\'' +
                ", indate=" + indate +
                ", connum=" + connum +
                ", ciid=" + ciid +
                ", csid=" + csid +
                ", note='" + note + '\'' +
                ", recorder='" + recorder + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
