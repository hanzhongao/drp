package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Shopcar;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IShopCarDao extends IBaseDAO<Long, Shopcar> {
    /**
     * 对购物车进行删除处理
     * @param mid 删除用户编号
     * @param gids 清除商品编号
     * @return
     * @throws SQLException
     */
    public boolean doRemoveByMember(String mid, Set<Long>gids) throws SQLException;
    /**
     * 进行购物车中内容的批量修改
     * @param
     * @return
     * @throws SQLException
     */
    public boolean doEditBatch(List<Shopcar> cars) throws SQLException;

    /**
     *  根据用户的编号和商品的编号查询对应的购物车中的信息
     *
     * @return
     * @throws SQLException
     */
    public Integer findAmountByMemberAndGoods(String mid,Integer gid) throws SQLException;

    /**
     *  根据用户信息和商品编号修改已有的商品信息
     * @param mids
     * @param gid
     * @param ammunt
     * @return
     */
    public boolean doEditAmonutByMemberAndGoods(String mids,Integer gid,Integer ammunt) throws SQLException;

    /**
     * 查询用户的全部的购物信息 key=商品id value=数量
     * @param mid
     * @return
     * @throws SQLException
     */
    public Map<Long,Integer> findAllByMember(String mid) throws SQLException;
}
