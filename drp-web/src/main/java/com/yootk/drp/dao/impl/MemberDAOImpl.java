package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.vo.Member;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
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
        String sql = "UPDATE member SET password=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, password);
        super.pstmt.setString(2, mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Member> findAllByType() throws SQLException {
        String sql = "SELECT mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid FROM member WHERE type=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, 1);
        return super.handleResultToList(super.pstmt.executeQuery(), Member.class);
    }

    @Override
    public Long getCountByType() throws SQLException {
        String sql = "select count(*) from member where type=1" ;
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L  ;
    }

    /**
     * 修改用户类型
     * @param mid 用户mid
     * @param type 用户类型 0：前端用户 1：后台雇员
     * @return 修改成功返回true,修改失败返回false
     * @throws SQLException
     * @author hanzhongao
     */
    @Override
    public boolean doEditType(String mid,Integer type) throws SQLException {
        String sql = "UPDATE member SET type=? WHERE mid=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,type);
        super.pstmt.setString(2,mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public Long getCountByType(String column, String keyWord) throws SQLException {
        String sql = "select count(*) from member where type=1 and " + column + " like ? " ;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L  ;
    }



    /**
     * 实现数据信息的增加操作，该方法主要执行的是INSERT更新语句
     * @param member 保存要增加数据的信息类
     * @return 数据保存成功返回true，否则返回false
     * @throws SQLException 数据库执行异常
     * @author hanzhongao
     */
    @Override
    public boolean doCreate(Member member) throws SQLException {
        String sql = "insert into member (mid,password,name,phone,did,lid,photo,note,sal,regdate) " +
                " values (?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,member.getMid());
        super.pstmt.setString(2,member.getPassword()) ;
        super.pstmt.setString(3,member.getName()) ;
        super.pstmt.setString(4,member.getPhone()) ;
        super.pstmt.setLong(5,member.getDid()) ;
        super.pstmt.setLong(6,member.getLid()) ;
        super.pstmt.setString(7,member.getPhoto()) ;
        super.pstmt.setString(8,member.getNote()) ;
        super.pstmt.setDouble(9,member.getSal());
        super.pstmt.setDate(10,new Date(member.getRegdate().getTime()));
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Member member) throws SQLException {
        super.conn = DatabaseConnection.getConnection();
        String sql = "update member set password=?,name=?,phone=?,did=?,lid=?,photo=?,note=?,sal=? where mid =?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,member.getPassword()) ;
        super.pstmt.setString(2,member.getName()) ;
        super.pstmt.setString(3,member.getPhone()) ;
        super.pstmt.setLong(4,member.getDid()) ;
        super.pstmt.setLong(5,member.getLid()) ;
        super.pstmt.setString(6,member.getPhoto()) ;
        super.pstmt.setString(7,member.getNote()) ;
        super.pstmt.setDouble(8,member.getSal());
        super.pstmt.setString(9,member.getMid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public Member findById(String s) throws SQLException {
        String sql = "SELECT mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, s);
        return super.handleResultToVO(super.pstmt.executeQuery(), Member.class);
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select mid,photo,name,lid,did,regdate,sal,phone from member where type=1 limit " + (currentPage - 1) * lineSize + ", " + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Member.class);
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "select photo,name,lid,did,regdate,sal,phone from member where type=1 and " + column + "  like ? limit " + + (currentPage - 1) * lineSize + ", " + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),Member.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("member");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("member",column,keyWord);
    }


}
