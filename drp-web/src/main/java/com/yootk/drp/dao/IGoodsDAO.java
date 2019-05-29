package com.yootk.drp.dao;

import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IGoodsDAO {
    /**
     * 根据已有的商品编号的信息查询出对应的所有商品数据
     * @param gids  商品编号
     * @return  返回商品信息列表
     * @throws SQLException JDBC
     */
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException ;
}
