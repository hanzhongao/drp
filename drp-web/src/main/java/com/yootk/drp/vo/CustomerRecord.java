package com.yootk.drp.vo;

import java.util.Date;

public class CustomerRecord {
    private Long crid;
    private String cmid;
    private Date cdate;
    private Long criid;
    private Long cuid;
    private String note;

    public CustomerRecord() {}

    public Long getCrid() {
        return crid;
    }

    public void setCrid(Long crid) {
        this.crid = crid;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Long getCriid() {
        return criid;
    }

    public void setCriid(Long criid) {
        this.criid = criid;
    }

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "crid=" + crid +
                ", cmid='" + cmid + '\'' +
                ", cdate=" + cdate +
                ", criid=" + criid +
                ", cuid=" + cuid +
                ", note='" + note + '\'' +
                '}';
    }
}
