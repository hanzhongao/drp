package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.ICustomerDAO;
import com.yootk.drp.vo.Customer;
import com.yootk.common.dao.abs.AbstractDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


/**
 * @author yaoxinlan
 */
@Repository
public class CustomerDAOImpl extends AbstractDAO implements ICustomerDAO {
    @Override
    public boolean doCreate(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer(mid,name,type,phone,pid,cid,address,note) VALUES (?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, customer.getMid());
        super.pstmt.setString(2, customer.getName());
        super.pstmt.setInt(3, customer.getType());
        super.pstmt.setString(4, customer.getPhone());
        super.pstmt.setLong(5, customer.getPid());
        super.pstmt.setLong(6, customer.getCid());
        super.pstmt.setString(7, customer.getAddress());
        super.pstmt.setString(8, customer.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public Customer findById(String s) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Customer getCInfo(String mid) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql = "SELECT cuid,mid,status FROM customer WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        return super.handleResultToVO(super.pstmt.executeQuery(), Customer.class);
    }
}
