package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.INewsDAO;
import com.yootk.drp.service.front.INewServiceFront;
import com.yootk.drp.vo.News;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class NewServiceFront extends AbstractService implements INewServiceFront {
    @Autowired
    private INewsDAO newsDAO;
    @Override
    public Map<String, Object> findAllNews(Long currentPage, Integer lineSize, String column, String keyword) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        if (column == null || "".equals(column) || keyword==null||"".equals(keyword)){
            map.put("allRecorders",this.newsDAO.getAllCount());
            map.put("allNews",this.newsDAO.findSplitStatus(currentPage,lineSize));
        } else {
            map.put("allRecorders",this.newsDAO.getAllCount(column,keyword));
            map.put("allNews",this.newsDAO.findSplitStatus(currentPage,lineSize,column,keyword));
        }
        return map;
    }

    @Override
    public Map<String,Object> findNewById(Long nid) throws SQLException {
        if (nid==null || "".equals(nid)){
            return null;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("news",this.newsDAO.findById(nid));
        return map;
    }
}
