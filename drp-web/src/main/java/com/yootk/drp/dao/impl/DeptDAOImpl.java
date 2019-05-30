package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IDeptDAO;
import com.yootk.drp.vo.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {
    @Override
    public boolean doCreate(Dept dept) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Dept dept) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    /**
     * 根据id查询部门信息
     *
     * @param aLong 根据此id查询部门信息
     * @return 部门vo类
     * @throws SQLException
     * @author hanzhongao
     */
    @Override
    public Dept findById(Long aLong) throws SQLException {
        String sql = "select did,dname,mid from dept where did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, aLong);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            Dept dept = new Dept();
            dept.setDid(rs.getLong(1));
            dept.setDname(rs.getString(2));
            dept.setMid(rs.getString(3));
            System.out.println(dept);
            return dept;
        }
        return null;
    }

    /**
     * 查询全部部门信息
     *
     * @return 全部部门信息
     * @throws SQLException
     * @author hanzhongao
     */
    @Override
    public List<Dept> findAll() throws SQLException {
        String sql = "select did,dname,mid from dept";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Dept.class);
    }

    @Override
    public List<Dept> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Dept> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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

    @Override
    public Map<Long, String> findAllMap() throws SQLException {
        Map<Long, String> map = new HashMap<>();
        String sql = "SELECT did,dname FROM dept";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            map.put(rs.getLong(1), rs.getString(2));
        }
        return map;
    }
}

