package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IWitemDao;
import com.yootk.drp.vo.Witem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @author wangran
 * 商品仓库用途
 */
@Repository
public class WitemDaoImpl extends AbstractDAO implements IWitemDao {
    @Override
    public boolean doCreate(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Witem findById(Long aLong) throws SQLException {
        String sql = "SELECT title FROM witem where wiid=?";
        super.conn = DatabaseConnection.getConnection();
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,aLong);
        return super.handleResultToVO(super.pstmt.executeQuery(),Witem.class);
    }

    @Override
    public List<Witem> findAll() throws SQLException {
        String sql = "select wiid,title from witem";
        super.conn = DatabaseConnection.getConnection();
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        return super.handleResultToList(super.pstmt.executeQuery(),Witem.class);
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
