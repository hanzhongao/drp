package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IGoodsDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
}
