package com.yootk.drp.vo;

import java.io.Serializable;

public class Details implements Serializable {
    private Long dtid;
    private Long oid;
    private Long gid;
    private Integer amount;

    @Override
    public String toString() {
        return "Details{" +
                "dtid=" + dtid +
                ", oid=" + oid +
                ", gid=" + gid +
                ", amount=" + amount +
                '}';
    }

    public Long getDtid() {
        return dtid;
    }

    public void setDtid(Long dtid) {
        this.dtid = dtid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
