package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Shopcar;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public interface IShopcarDAO extends IBaseDAO<Long, Shopcar> {

    /**
     * 根据用户编号和商品编号查找购物车商品数量
     * @param mid   用户编号
     * @param gid   商品编号
     * @return      返回数值，没有，则为null
     * @throws SQLException SQL
     */
    public Integer findAmountByMemberAndGoods(String mid, Long gid) throws SQLException ;

    /**
     * 根据用户编号查询所有的购物车数据信息
     * @param mid   用户编号
     * @return      返回Map集合
     * key=商品id集合，value=商品数量
     * @throws SQLException JDBC
     */
    public Map<Long,Integer> findAllByMember(String mid) throws SQLException ;

    /**
     * 对购物车进行删除处理
     * @param mid 删除用户编号
     * @param gids 清除商品编号
     * @return
     * @throws SQLException
     */
    public boolean doRemoveByMember(String mid, Set<Long> gids) throws SQLException;

}
