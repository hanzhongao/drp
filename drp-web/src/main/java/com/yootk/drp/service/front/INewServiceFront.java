package com.yootk.drp.service.front;

import com.yootk.drp.vo.News;

import java.sql.SQLException;
import java.util.Map;

public interface INewServiceFront {
    public Map<String,Object> findAllNews(Long currentPage, Integer lineSize, String column, String keyword) throws SQLException;
    public Map<String,Object> findNewById(Long nid) throws SQLException;
}
