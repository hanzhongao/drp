package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
    @Override
    public Integer getTypeByMid(String mid) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql = "SELECT type FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return null;
    }

    @Override
    public boolean doEditMessage(String mid, String name, String phone, String email) throws SQLException {
        String sql = "UPDATE member SET name=?,phone=?,email=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, name);
        super.pstmt.setString(2, phone);
        super.pstmt.setString(3, email);
        super.pstmt.setString(4, mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public String findByPassword(String mid) throws SQLException {
        String sql = "SELECT password FROM member WHERE mid =? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public boolean doEditPassword(String mid, String password) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql = "UPDATE member SET password=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, password);
        super.pstmt.setString(2, mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public Member findMessageInfo(String mid) throws SQLException {
        String sql = "SELECT mid,name,lid,did,phone,note FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        return super.handleResultToVO(super.pstmt.executeQuery(),Member.class);
    }

    @Override
    public boolean doCreate(Member member) throws SQLException {
        String sql = "INSERT INTO member(mid,password,type) VALUES (?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,member.getMid());
        super.pstmt.setString(2,member.getPassword());
        super.pstmt.setInt(3,0);
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public Member findById(String s) throws SQLException {
        String sql = "SELECT mid,lid,cuid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,s);
        return super.handleResultToVO(super.pstmt.executeQuery(),Member.class);
    }
    @Override
    public boolean doEdit(Member member) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
