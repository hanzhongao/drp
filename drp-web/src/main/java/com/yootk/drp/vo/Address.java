package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * 联系地址表
 * @author yaoxinlan
 */
public class Address implements Serializable {
    private Integer adid;
    private String mid;
    private Integer cid;
    private Integer pid;
    private String addr;
    private String receiver;
    private String phone;
    private Integer deflag;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDeflag() {
        return deflag;
    }

    public void setDeflag(Integer deflag) {
        this.deflag = deflag;
    }

    @Override
    public String toString() {
        return "Address{" +
                "adid=" + adid +
                ", mid='" + mid + '\'' +
                ", cid=" + cid +
                ", pid=" + pid +
                ", addr='" + addr + '\'' +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", deflag=" + deflag +
                '}';
    }
}
