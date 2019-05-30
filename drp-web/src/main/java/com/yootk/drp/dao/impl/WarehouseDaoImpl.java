package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IWarehouseDao;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @author 枉然
 */
@Repository
public class WarehouseDaoImpl extends AbstractDAO implements IWarehouseDao {
    @Override
    public City findByCid(Long cid) throws SQLException {
        String sql = "SELECT cid,pid,title FROM city where cid=?";
        super.conn = DatabaseConnection.getConnection();
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,cid);
        return super.handleResultToVO(super.pstmt.executeQuery(),City.class);
    }

    @Override
    public Warehouse findByAllWiid() throws SQLException {
        String sql = "select wiid from warehouse";
        super.conn = DatabaseConnection.getConnection();
        super.pstmt =super.conn.prepareStatement(sql);
        return super.handleResultToVO(super.pstmt.executeQuery(),Warehouse.class);
    }

    @Override
    public boolean doCreate(Warehouse vo) throws SQLException {
        String sql = "INSERT INTO  warehouse  (name,pid,cid,wiid,address,area,maximum,photo,note,recorder,admin) VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getName());
        super.pstmt.setLong(2,vo.getPid());
        super.pstmt.setLong(3,vo.getCid());
        //用途Id
        super.pstmt.setLong(4,vo.getWiid());
        super.pstmt.setString(5,vo.getAddress());
        //仓库面积
        super.pstmt.setDouble(6,vo.getArea());
        //最大存储数量
        super.pstmt.setInt(7,vo.getMaximum());
        super.pstmt.setString(8,vo.getPhoto());
        super.pstmt.setString(9,vo.getNote());
        //当前管理员
        super.pstmt.setString(10,vo.getRecorder());
        //当前管理员
        super.pstmt.setString(11,vo.getAdmin());
        return super.pstmt.executeUpdate() >0;
    }

    @Override
    public boolean doEdit(Warehouse warehouse) throws SQLException {
        String sql ="update warehouse set name=?,pid=?,cid=?,wiid=?,address=?,area=?,maximum=?,photo=?,note=?,recorder=?,admin=? where wid=?";
        super.conn = DatabaseConnection.getConnection();
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,warehouse.getName());
        super.pstmt.setLong(2,warehouse.getPid());
        super.pstmt.setLong(3,warehouse.getCid());
        super.pstmt.setLong(4,warehouse.getWiid());
        super.pstmt.setString(5,warehouse.getAddress());
        super.pstmt.setDouble(6,warehouse.getArea());
        super.pstmt.setLong(7,warehouse.getMaximum());
        super.pstmt.setString(8,warehouse.getPhoto());
        super.pstmt.setString(9,warehouse.getNote());
        super.pstmt.setString(10,warehouse.getRecorder());
        super.pstmt.setString(11,warehouse.getAdmin());
        super.pstmt.setLong(12,warehouse.getWiid());
        return super.pstmt.executeUpdate() >0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Warehouse findById(Long aLong) throws SQLException {
       String sql = "SELECT name,pid,cid,wiid, address,area,maximum,currnum, photo,note,recorder,admin from warehouse where wid=?";
       super.pstmt =super.conn.prepareStatement(sql);
       super.pstmt.setLong(1,aLong);
       return super.handleResultToVO(super.pstmt.executeQuery(),Warehouse.class);
    }

    @Override
    public List<Warehouse> findAll() throws SQLException {
        String sql = "SELECT wid,name,pid,cid,wiid, address,area,maximum,currnum, photo,note,recorder,admin from warehouse";
        super.conn = DatabaseConnection.getConnection();
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Warehouse.class);
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT wid,name,pid,cid,wiid, address,area,maximum,currnum, photo,note,recorder,admin from warehouse limit " +
                +(currentPage-1)*lineSize +","+lineSize;
        super.conn = DatabaseConnection.getConnection();
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Warehouse.class);
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "SELECT wid,name,pid,cid,wiid, address,area,maximum,currnum, photo,note,recorder,admin from warehouse where " + column +" like ? limit " +
                +(currentPage-1)*lineSize +","+lineSize;
        super.conn = DatabaseConnection.getConnection();
        super.pstmt= super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%" +keyWord+"%");
        System.out.println(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Warehouse.class);
    }
    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("warehouse");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("warehouse",column,keyWord);
    }
}
