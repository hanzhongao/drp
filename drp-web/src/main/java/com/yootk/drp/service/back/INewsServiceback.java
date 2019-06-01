package com.yootk.drp.service.back;

import com.yootk.drp.vo.News;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface INewsServiceback {
    public boolean addNews(News news) throws SQLException;
    public Map<String, Object> findAllNews(Long currentPage, Integer lineSize, String column, String keyword) throws SQLException;
    public Map<String,Object> editPre(Long nid) throws SQLException;
    public String findPhotoById(Long nid) throws SQLException;
    public boolean edit(News news) throws SQLException;
    public boolean updateStatusById(String nid, Set<Integer> nids) throws SQLException;
    public int[] findStatusById(Set<Integer> nids) throws SQLException;
    public boolean doRemove(Set<Long> nid) throws SQLException;


}
