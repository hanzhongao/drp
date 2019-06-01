package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.INewsDAO;
import com.yootk.drp.service.back.INewsServiceback;
import com.yootk.drp.vo.News;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class NewsServicebackImpl extends AbstractService implements INewsServiceback {
    @Autowired
    private INewsDAO newsDAO;

    @Override
    public boolean addNews(News news) throws SQLException {
        return newsDAO.doCreate(news);
    }

    @Override
    public Map<String,Object> findAllNews(Long currentPage, Integer lineSize, String column, String keyword) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        if (column == null || "".equals(column) || keyword==null||"".equals(keyword)){
            map.put("allRecorders",this.newsDAO.getAllCount());
            map.put("allNews",this.newsDAO.findSplit(currentPage,lineSize));
        } else {
            map.put("allRecorders",this.newsDAO.getAllCount(column,keyword));
            map.put("allNews",this.newsDAO.findSplit(currentPage,lineSize,column,keyword));
        }
        return map;
    }

    @Override
    public Map<String,Object> editPre(Long nid) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        News news = this.newsDAO.findById(nid);
        map.put("news",news);
        return map;
    }

    @Override
    public String findPhotoById(Long nid) throws SQLException {
        return this.newsDAO.findPhotoById(nid);
    }

    @Override
    public boolean edit(News news) throws SQLException {
        return this.newsDAO.doEdit(news);
    }

    @Override
    public boolean updateStatusById(String issuer, Set<Integer> nids) throws SQLException {
        if (nids ==null || nids.size()==0){
            return false;
        }
        return this.newsDAO.updateStatusById(issuer,nids);
    }

    @Override
    public int[] findStatusById(Set<Integer> nids) throws SQLException {
        return this.newsDAO.findStatusById(nids);
    }

    @Override
    public boolean doRemove(Set<Long> nid) throws SQLException {
        return this.newsDAO.doRemove(nid);
    }

}
