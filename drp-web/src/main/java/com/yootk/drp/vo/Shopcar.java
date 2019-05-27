package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * 这是一个购物车的简单vo类
 */
public class Shopcar implements Serializable {
    private Long scid;
    private String mid;
    private Integer gid;
    private Integer amount;

    public Long getScid() {
        return scid;
    }

    public void setScid(Long scid) {
        this.scid = scid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Shopcar{" +
                "scid=" + scid +
                ", mid='" + mid + '\'' +
                ", gid=" + gid +
                ", amount=" + amount +
                '}';
    }
}


