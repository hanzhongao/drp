package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.ISubtypeDAO;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Subtype;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class SubtypeDAOImpl extends AbstractDAO implements ISubtypeDAO {
    @Override
    public List<Subtype> findByIdWitem(Long wiid) throws SQLException {
        String sql = "SELECT stid,title,wiid FROM subtype WHERE wiid=?";
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,wiid);
        return super.handleResultToList(super.pstmt.executeQuery(), Subtype.class);
    }

    @Override
    public boolean doCreate(Subtype subtype) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Subtype subtype) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Subtype findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Subtype> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Subtype> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Subtype> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
