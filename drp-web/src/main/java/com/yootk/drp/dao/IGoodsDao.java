package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @author 再次BUG更改
 */
public interface IGoodsDAO extends IBaseDAO<Long, Goods>  {
    /**
     * 根据已有的商品编号的信息查询出对应的所有商品数据
     * @param gids  商品编号
     * @return  返回商品信息列表
     * @throws SQLException JDBC
     */
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException ;
    public String findPhotoById(Long gid) throws SQLException;
}
