package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IProvinceDAO;
import com.yootk.drp.vo.Province;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class ProvinceDAOImpl extends AbstractDAO implements IProvinceDAO {
    @Override
    public boolean doCreate(Province province) throws SQLException {
            return false;
    }

    @Override
    public boolean doEdit(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Province findById(Long aLong) throws SQLException {
        return null;
    }

    /**
     *  查询全部省份信息
     * @return 返回省份信息列表
     * @throws SQLException
     * @author 韩中傲
     */
    @Override
    public List<Province> findAll() throws SQLException {
        List<Province> all = new ArrayList<>() ;
        Province pro = null ;
        String sql = "select pid,title from province" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            pro = new Province() ;
            pro.setPid(rs.getLong(1));
            pro.setTitle(rs.getString(2));
           all.add(pro) ;
        }
        return all;
    }

    @Override
    public List<Province> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Province> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
