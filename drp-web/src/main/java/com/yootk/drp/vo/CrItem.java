package com.yootk.drp.vo;

import java.io.Serializable;

public class CrItem implements Serializable {
    private Long crrid;
    private String title;

    public CrItem(){}

    public Long getCrrid() {
        return crrid;
    }

    public void setCrrid(Long crrid) {
        this.crrid = crrid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CrItem{" +
                "crrid=" + crrid +
                ", title='" + title + '\'' +
                '}';
    }
}
