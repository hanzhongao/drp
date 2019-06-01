package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IDetailsDAO;
import com.yootk.drp.vo.Details;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @Author ${hutao}
 * @create 2019/5/29 9:44
 */
@Repository
public class DetailsDAOImpl extends AbstractDAO implements IDetailsDAO {
    @Override
    public boolean doCreateBatch(List<Details> allDetails) throws SQLException {
        String sql = "INSERT INTO details(oid,gid,amount) VALUES (?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        for (Details details : allDetails) {
            super.pstmt.setLong(1,details.getOid());
            super.pstmt.setLong(2,details.getGid());
            super.pstmt.setInt(3,details.getAmount());
            super.pstmt.addBatch();
        }
        return super.isBatchSuccess(super.pstmt.executeBatch());
    }

    @Override
    public boolean doCreate(Details details) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Details details) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Details findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Details> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Details> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Details> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
