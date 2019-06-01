package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IGoodsDAO;
import com.yootk.drp.vo.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 再次BUG更改
 */
@Repository
public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO {
    @Override
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException {
        List<Goods> all = new ArrayList<>() ;
        StringBuffer sql = new StringBuffer("SELECT gid,name,price,photo FROM goods WHERE gid IN(") ;
        for(Long gid : gids){
            sql.append(gid).append(",") ;
        }
        sql.delete(sql.length()-1,sql.length()).append(")") ;
        super.pstmt = super.conn.prepareStatement(sql.toString()) ;
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public String findPhotoById(Long gid) throws SQLException {
        String sql = "SELECT photo FROM goods WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,gid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public boolean doCreate(Goods goods) throws SQLException {
        String sql = "INSERT INTO goods(name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,goods.getName());
        super.pstmt.setLong(2,goods.getWiid());
        super.pstmt.setLong(3,goods.getStid());
        super.pstmt.setDouble(4,goods.getPrice());
        super.pstmt.setDouble(5,goods.getWeight());
        super.pstmt.setString(6,goods.getPhoto());
        super.pstmt.setString(7,goods.getNote());
        super.pstmt.setTimestamp(8,goods.getLastin());
        super.pstmt.setInt(9,goods.getStornum());
        super.pstmt.setString(10,goods.getRecorder());
        super.pstmt.setInt(11,0);
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(Goods goods) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql = "UPDATE goods SET name=?,wiid=?,stid=?,price=?,weight=?,photo=?,note=?,recorder=? WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,goods.getName());
        super.pstmt.setLong(2,goods.getWiid());
        super.pstmt.setLong(3,goods.getStid());
        super.pstmt.setDouble(4,goods.getPrice());
        super.pstmt.setDouble(5,goods.getWeight());
        super.pstmt.setString(6,goods.getPhoto());
        super.pstmt.setString(7,goods.getNote());
        super.pstmt.setString(8,goods.getRecorder());
        super.pstmt.setLong(9,goods.getGid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Goods findById(Long aLong) throws SQLException {
        String sql = "SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,aLong);
//        ResultSet rs = super.pstmt.executeQuery();
//        if (rs.next()){
//             goods = new Goods();
//             goods.setGid(rs.);
//             goods.setName();
//             goods.setWiid();
//             goods.setStid();
//             goods.setPrice();
//             goods.setWeight();
//             goods.setPhoto();
//             goods.setNote();
//             goods.setLastin();
//             goods.setStornum();
//             goods.set
//             goods.setWeight();
//        }
        return super.handleResultToVO(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findAll() throws SQLException {
        String sql ="SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods Where delflag=0";
        super.pstmt = super.conn.prepareStatement(sql);
        return super. handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        List<Goods> all = new ArrayList<Goods>();
        String sql = "SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods WHERE delflag=?  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,0);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        List<Goods> all = new ArrayList<Goods>();
        String sql = "SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods WHERE delflag=? AND " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,0);
        super.pstmt.setString(2, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("goods");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("goods",column,keyWord) ;
    }
}
