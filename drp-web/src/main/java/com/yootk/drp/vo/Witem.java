package com.yootk.drp.vo;

import java.io.Serializable ;

public class Witem implements Serializable {
    private Long wiid ;
    private String title ;

    @Override
    public String toString() {
        return "Witem{" +
                "wiid=" + wiid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getWiid() {
        return wiid;
    }

    public void setWiid(Long wiid) {
        this.wiid = wiid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
