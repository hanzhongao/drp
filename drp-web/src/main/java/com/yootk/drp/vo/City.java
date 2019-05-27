package com.yootk.drp.vo;

import java.io.Serializable;

public class City implements Serializable {
    private Long cid ;
    private Long pid ;
    private String title ;

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
