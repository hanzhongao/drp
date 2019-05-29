package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IGoodsDao;
import com.yootk.drp.vo.Goods;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class GoodsDaoImpl extends AbstractDAO implements IGoodsDao {
    @Override
    public List<Goods> findAllByGods(Set<Long> gids) throws SQLException {
        if(!(gids.size()==0)){
            StringBuffer sql = new StringBuffer("select gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods Where delflag=0 and gid in (");
            for (Long gid : gids) {
                sql.append(gid).append(",") ;
            }
            sql.delete(sql.length() - 1,sql.length()).append(")") ;
            List<Goods> all = new ArrayList<Goods>();
            super.pstmt = super.conn.prepareStatement(sql.toString());
            return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
        }else{
            return null;
        }
    }

    @Override
    public boolean doCreate(Goods goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Goods goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Goods findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findAll() throws SQLException {
        String sql ="SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,FROM goods Where delflag=0";
        super.pstmt = super.conn.prepareStatement(sql);
        return super. handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
