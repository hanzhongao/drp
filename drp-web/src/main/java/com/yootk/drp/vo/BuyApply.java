package com.yootk.drp.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购申请订单
 *
 * create table buy_apply (
 * 	bid bigint	AUTO_INCREMENT ,
 * 	content varchar(50),
 * 	name    varchar(50),
 * 	phone   varchar(20),
 * 	pid     bigint,
 * 	cid     bigint,
 * 	address varchar(100),
 * 	note    text,
 * 	status  int ,
 * 	subdate	datetime ,
 * 	CONSTRAINT pk_bid PRIMARY KEY (bid)
 * ) engine='innodb';
 */
public class BuyApply implements Serializable {
    private  Long    bid      ;
    private  String  mid      ;
    private  String  content  ;
    private  String  name     ;
    private  String  phone    ;
    private  Long    pid      ;
    private  Long    cid      ;
    private  String  address  ;
    private  String  note     ;
    private  Integer status   ;
    private  Date    subdate  ;

    public BuyApply() {
    }

    public BuyApply(Long bid, String mid, String content, String name, String phone, Long pid, Long cid, String address, String note, Integer status, Date subdate) {
        this.bid = bid;
        this.mid = mid;
        this.content = content;
        this.name = name;
        this.phone = phone;
        this.pid = pid;
        this.cid = cid;
        this.address = address;
        this.note = note;
        this.status = status;
        this.subdate = subdate;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubdate() {
        return subdate;
    }

    public void setSubdate(Date subdate) {
        this.subdate = subdate;
    }

    @Override
    public String toString() {
        return "BuyApply{" +
                "bid=" + bid +
                ", mid='" + mid + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", subdate=" + subdate +
                '}';
    }
}
