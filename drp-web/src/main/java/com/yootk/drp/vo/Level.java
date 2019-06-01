package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * 职位信息表
 */
public class Level implements Serializable {
    private Long lid ;
    private String title ;

    public Level() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Level{" +
                "lid=" + lid +
                ", title='" + title + '\'' +
                '}';
    }
}
