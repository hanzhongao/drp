package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IOrdersDAO;
import com.yootk.drp.vo.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @Author ${hutao}
 * @create 2019/5/29 9:34
 */
@Repository
public class OrdersDAOImpl extends AbstractDAO implements IOrdersDAO {
    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }

    @Override
    public boolean doCreate(Orders orders) throws SQLException {
        String sql = "INSERT INTO orders(mid,adid,subdate,price,note) VALUES (?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,orders.getMid());
        super.pstmt.setInt(2,orders.getAdid());
        super.pstmt.setDate(3,new java.sql.Date(orders.getSubdata().getTime()));
        super.pstmt.setDouble(4,orders.getPrice());
        super.pstmt.setString(5,orders.getText());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Orders orders) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Orders findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
