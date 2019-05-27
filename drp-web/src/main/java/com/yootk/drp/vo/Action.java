package com.yootk.drp.vo;

import java.io.Serializable;

public class Action implements Serializable {
    private String actid ;
    private String rid ;
    private String title ;

    public Action() {
    }

    public Action(String actid, String rid, String title) {
        this.actid = actid;
        this.rid = rid;
        this.title = title;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
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
        return "Action{" +
                "actid='" + actid + '\'' +
                ", rid='" + rid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
