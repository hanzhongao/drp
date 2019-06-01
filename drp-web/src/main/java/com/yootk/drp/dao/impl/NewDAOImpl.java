package com.yootk.drp.dao.impl;


import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.INewsDAO;
import com.yootk.drp.vo.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class NewDAOImpl extends AbstractDAO implements INewsDAO {
    @Override
    public boolean doCreate(News news) throws SQLException {
        String sql = "INSERT INTO news(title,abs,photo,note,status) VALUES (?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,news.getTitle());
        super.pstmt.setString(2,news.getAbs());
        super.pstmt.setString(3,news.getPhoto());
        super.pstmt.setString(4,news.getNote());
        super.pstmt.setInt(5,news.getStatus());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(News news) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql ="UPDATE news SET title=?,abs=?,photo=?,note=?,status=?,issuer=? WHERE nid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,news.getTitle());
        super.pstmt.setString(2,news.getAbs());
        super.pstmt.setString(3,news.getPhoto());
        super.pstmt.setString(4,news.getNote());
        super.pstmt.setInt(5,news.getStatus());
        super.pstmt.setString(6,news.getIssuer());
        super.pstmt.setLong(7,news.getNid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        String sql = "DELECT news WHERE nid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        for (Long along:longs){
            super.pstmt.setLong(1,along);
            super.pstmt.addBatch();
        }
        return super.handleRemove("news","nid",longs);
    }

    @Override
    public News findById(Long aLong) throws SQLException {
        String sql = "SELECT nid,title,abs,photo,note,status FROM news WHERE nid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,aLong);
        return super.handleResultToVO(super.pstmt.executeQuery(),News.class);
    }

    @Override
    public List<News> findAll() throws SQLException {
        String sql = "SELECT nid,title,abs,photo,note,pushTime,status FROM news ";
        return super.handleResultToList(super.pstmt.executeQuery(),News.class);
    }

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT nid,title,abs,photo,note,status FROM news   LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),News.class);
    }

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "SELECT nid,title,abs,photo,note,status FROM news WHERE  " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),News.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("news");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("news",column,keyWord) ;
    }

    @Override
    public String findPhotoById(Long nid) throws SQLException {
        String sql = "SELECT photo FROM news WHERE nid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,nid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public boolean updateStatusById(String issuer,Set<Integer> nids) throws SQLException {
        StringBuffer sql = new StringBuffer("UPDATE news SET status=? WHERE nid IN ( ");
        for (Integer nid : nids){
            sql.append(nid).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.setInt(1,1);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public int[] findStatusById(Set<Integer> nids) throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT status FROM news FROM nid IN (");
        for (Integer nid : nids){
            sql.append(nid).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.execute();
        return super.pstmt.executeBatch();
    }

    @Override
    public List<News> findSplitStatus(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT nid,title,abs,photo,note,status FROM news WHERE status= "+ 1 +" LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),News.class);
    }

    @Override
    public List<News> findSplitStatus(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "SELECT nid,title,abs,photo,note,status FROM news WHERE  status=? "  + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,1);
        super.pstmt.setString(2, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),News.class);
    }


}
