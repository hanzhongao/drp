package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IShopCarDao;
import com.yootk.drp.vo.Shopcar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ShopCarDaoImpl extends AbstractDAO implements IShopCarDao {
    @Override
    public boolean doRemoveByMember(String mid, Set<Long> gids) throws SQLException {
        System.out.println(mid+"::::"+gids);
        StringBuffer sql = new StringBuffer("delete from shopcar where mid=? and gid in(");
        for (Long gid :gids){
            sql.append(gid).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        System.out.println(sql.toString());
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.setString(1,mid);
        return super.pstmt.executeUpdate() >0;
    }

    @Override
    public boolean doEditBatch(List<Shopcar> cars) throws SQLException {
        String sql = "UPDATE shopcar set amount=? where mid=? and gid=?";
        super.pstmt = super.pstmt = super.conn.prepareStatement(sql);
        for (Shopcar car :cars){
            super.pstmt.setInt(1,car.getAmount());
            super.pstmt.setString(2,car.getMid());
            super.pstmt.setLong(3,car.getGid());
            super.pstmt.addBatch();
        }
        int result[] = super.pstmt.executeBatch();
        return super.isBatchSuccess(result);
    }

    @Override
    public Map<Long, Integer> findAllByMember(String mid) throws SQLException {
        Map<Long,Integer> map = new HashMap<>();
        String sql="select gid,amount from shopcar where mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            //商品编号对应数量
            map.put(rs.getLong(1),rs.getInt(2));
        }
        return map;
    }

    @Override
    public boolean doEditAmonutByMemberAndGoods(String mids, Integer gid, Integer ammunt) throws SQLException {
        String sql ="update shopcar set amount=? where mid=? and gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,ammunt);
        super.pstmt.setString(2,mids);
        super.pstmt.setInt(3,gid);
        return super.pstmt.executeUpdate() >0;
    }

    @Override
    public Integer findAmountByMemberAndGoods(String mid, Integer gid) throws SQLException {
        String sql = "select amount FROM shopcar where mid=? and gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        super.pstmt.setInt(2,gid);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            System.out.println(rs.getInt(1));
            return rs.getInt(1);
        }else {
            return null;
        }

    }

    @Override
    public boolean doCreate(Shopcar shopcar) throws SQLException {
        String sql = "insert into shopcar(mid,gid,amount) values(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,shopcar.getMid());
        super.pstmt.setInt(2,shopcar.getGid());
        super.pstmt.setInt(3,shopcar.getAmount());
        return super.pstmt.executeUpdate() >0;
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
}
