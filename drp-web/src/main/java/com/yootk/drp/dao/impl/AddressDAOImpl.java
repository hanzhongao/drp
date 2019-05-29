package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IAddressDAO;

import com.yootk.drp.vo.Address;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {
    @Override
    public boolean doCreate(Address address) throws SQLException {
        String sql = "INSERT INTO address(mid,phone,pid,cid,addr,receiver) VALUES (?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,address.getMid());
        super.pstmt.setString(2,address.getPhone());
        super.pstmt.setLong(3,address.getPid());
        super.pstmt.setLong(4,address.getCid());
        super.pstmt.setString(5,address.getAddr());
        super.pstmt.setString(6,address.getReceiver());
        return super.pstmt.executeUpdate() > 0;
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
