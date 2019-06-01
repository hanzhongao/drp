package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.News;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface INewsDAO extends IBaseDAO<Long, News> {
    public String findPhotoById(Long nid) throws SQLException;
    public boolean updateStatusById(String issuer, Set<Integer> nids) throws SQLException;
    public int[] findStatusById(Set<Integer> nids) throws SQLException;
    public List<News> findSplitStatus(Long currentPage, Integer lineSize) throws SQLException;
    public List<News> findSplitStatus(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException;
}
