package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public interface IGoodsDao extends IBaseDAO<Long, Goods> {
    /**
     * 根据已有的商品编号的信息，查询商品
     * @param gids
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByGods(Set<Long> gids) throws SQLException;
}
