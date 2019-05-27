package com.yootk.drp.vo;

import java.io.Serializable;

public class Role implements Serializable {
    private String rid ;
    private String title ;

    public Role() {
    }

    public Role(String rid, String title) {
        this.rid = rid;
        this.title = title;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid='" + rid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
