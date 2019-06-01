package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;

import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IAddressDAO;

import com.yootk.drp.vo.Address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Repository
public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {
    @Override
    public boolean doCreate(Address address) throws SQLException {
        String sql = "INSERT INTO address(mid,phone,pid,cid,addr,receiver,deflag) VALUES (?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, address.getMid());
        super.pstmt.setString(2, address.getPhone());
        super.pstmt.setLong(3, address.getPid());
        super.pstmt.setLong(4, address.getCid());
        super.pstmt.setString(5, address.getAddr());
        super.pstmt.setString(6, address.getReceiver());
        super.pstmt.setInt(7, 0);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Address> findAll() throws SQLException {
        List<Address> all = new ArrayList<>();
        String sql = "SELECT adid,mid,cid,pid,addr,receiver,phone FROM address WHERE flag=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, 0);
        return super.handleResultToList(super.pstmt.executeQuery(),Address.class);
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

    @Override
    public List<Address> findAddressByMember(String mid) throws SQLException {
        List<Address> addressesList = new ArrayList<>();
        String sql = "SELECT mid,cid,pid,addr,receiver,phone FROM address WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        return super.handleResultToList(super.pstmt.executeQuery(), Address.class);
    }

    @Override
    public boolean doRemoveByMemberAndAdid(String mid, Set<Integer> adids) throws SQLException {
        StringBuffer sql = new StringBuffer("DELETE FROM address WHERE mid=? AND adid IN ( ");
        for (Integer adid : adids){
            sql.append(adid).append(",");
        }
        sql.delete(sql.length() - 1,sql.length() ).append(")") ;
        super.pstmt = super.conn.prepareStatement(sql.toString()) ;
        super.pstmt.setString(1,mid);
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Address address) throws SQLException {
        String sql = "UPDATE address SET receiver=?,phone=?,pid=?,cid=?,addr=? WHERE adid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, address.getReceiver());
        super.pstmt.setString(2, address.getPhone());
        super.pstmt.setInt(3, address.getPid());
        super.pstmt.setInt(4, address.getCid());
        super.pstmt.setString(5, address.getAddr());
        super.pstmt.setInt(6,address.getAdid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {

        return false;
    }

    @Override
    public Address findById(Long aLong) throws SQLException {
        //super.conn = DatabaseConnection.getConnection();
        String sql = "SELECT adid,cid,pid,addr,receiver,phone,deflag FROM address WHERE adid=? AND  deflag=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,aLong);
        super.pstmt.setInt(2,0);
        return super.handleResultToVO(super.pstmt.executeQuery(), Address.class);
    }
    @Override
    public List<Address> findSplit(String mid,Long currentPage, Integer lineSize) throws SQLException {
        List<Address> all = new ArrayList<Address>();
        String sql = "SELECT adid,mid,cid,pid,addr,receiver,phone FROM address WHERE deflag=? AND mid=?  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,0);
        super.pstmt.setString(2,mid);
        return super.handleResultToList(super.pstmt.executeQuery(),Address.class);
    }

    @Override
    public List<Address> findSplit(String mid,Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        List<Address> all = new ArrayList<Address>();
        String sql = "SELECT adid,mid,cid,pid,addr,receiver,phone FROM address WHERE deflag=? AND mid=?" + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setString(2,mid);
        return super.handleResultToList(super.pstmt.executeQuery(),Address.class);
    }

    @Override
    public Long getAllCount(String mid) throws SQLException {
        return super.handleCount(mid,"address");
    }

    @Override
    public Long getAllCount(String mid,String column, String keyWord) throws SQLException {
        return super.handleCount(mid,"address",column,keyWord) ;
    }

}











