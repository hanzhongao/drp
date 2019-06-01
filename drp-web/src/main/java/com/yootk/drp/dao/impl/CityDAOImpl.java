package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.IBaseDAO;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.ICityDAO;
import com.yootk.drp.vo.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CityDAOImpl extends AbstractDAO implements ICityDAO {

    /**
     * 查询指定省下的所有城市
     * @param pid  省份编号
     * @return 省下的所有城市名称
     * @throws SQLException
     * @author 韩中傲
     */
    @Override
    public List<City> findByPid(Long pid) throws SQLException {
        String sql = "select cid,title from city where pid=?";
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,pid);
        return super.handleResultToList(super.pstmt.executeQuery(),City.class);
    }

    @Override
    public City findTitle(Integer cid) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql = "SELECT cid,title FROM city WHERE cid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,cid);
        return super.handleResultToVO(super.pstmt.executeQuery(),City.class);
    }

    @Override
    public boolean doCreate(City city) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(City city) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public City findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<City> findAll() throws SQLException {
        String sql = "select pid,cid,title from city ";
        super.pstmt = super.conn.prepareStatement(sql) ;
        return super.handleResultToList(super.pstmt.executeQuery(),City.class);
    }

    @Override
    public List<City> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<City> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
