package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IWarehouseDao;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class WarehouseDaoImpl extends AbstractDAO implements IWarehouseDao {
    @Override
    public boolean doCreate(Warehouse vo) throws SQLException {
        String sql = "INSERT INTO  warehouse  (name ,pid ,cid ,wiid , address , area ,maximum ,currnum ,photo ,note ,recorder ,admin ) VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getName());
        super.pstmt.setLong(2,vo.getPid());
        super.pstmt.setLong(3,vo.getCid());
        //用途Id
        super.pstmt.setLong(4,vo.getWid());
        super.pstmt.setString(5,vo.getAddress());
        //仓库面积
        super.pstmt.setDouble(6,vo.getArea());
        //最大存储数量
        super.pstmt.setInt(7,vo.getMaximum());
        //仓储当前商品存储容量
        super.pstmt.setInt(8,vo.getCurrnum());
        super.pstmt.setString(9,vo.getPhoto());
        super.pstmt.setString(10,vo.getNote());
        super.pstmt.setString(11,vo.getRecorder());
        super.pstmt.setString(12,vo.getAdmin());
        return super.pstmt.executeUpdate() >0;
    }

    @Override
    public boolean doEdit(Warehouse warehouse) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Warehouse findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
