package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IAddressDAO;
import com.yootk.drp.vo.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author ${hutao}
 * @create 2019/5/28 10:41
 */
@Repository
public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {
    @Override
    public List<Address> findAddressByMember(String mid) throws SQLException {
        List<Address> addressesList = new ArrayList<>();
        String sql = "SELECT mid,cid,pid,addr,receiver,phone FROM address WHERE mid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,mid);
        return super.handleResultToList(super.pstmt.executeQuery(),Address.class);
    }

    @Override
    public boolean doCreate(Address address) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Address address) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Address findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Address> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Address> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Address> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
