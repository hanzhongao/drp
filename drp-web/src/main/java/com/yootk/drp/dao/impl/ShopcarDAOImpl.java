package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IShopcarDAO;
import com.yootk.drp.vo.Shopcar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ShopcarDAOImpl extends AbstractDAO implements IShopcarDAO {

    @Override
    public boolean doRemoveByMember(String mid, Set<Long> gids) throws SQLException {
        StringBuffer sql = new StringBuffer("delete from shopcar where mid=? and gid in(");
        for (Long gid :gids){
            sql.append(gid).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.setString(1,mid);
        return super.pstmt.executeUpdate() >0;
    }

    @Override
    public boolean doCreate(Shopcar shopcar) throws SQLException {

        return false;
    }

    @Override
    public boolean doEdit(Shopcar shopcar) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Shopcar findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Shopcar> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Shopcar> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Shopcar> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Integer findAmountByMemberAndGoods(String mid, Long gid) throws SQLException {
        String sql = "SELECT amount FROM shopcar WHERE mid=? AND gid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,mid);
        super.pstmt.setLong(2,gid);
        ResultSet rs = super.pstmt.executeQuery() ;
        if(rs.next()){
            return rs.getInt(1) ;
        }
        return null;
    }

    @Override
    public Map<Long, Integer> findAllByMember(String mid) throws SQLException {
        Map<Long,Integer> map = new HashMap<>() ;
        String sql = "SELECT gid,amount FROM shopcar WHERE mid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery() ;
        while (rs.next()){
            map.put(rs.getLong(1),rs.getInt(2)) ;   //保存商品和编号的对应数量
        }
        return map;
    }
}
