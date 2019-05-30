package com.yootk.drp.service.front;

import com.yootk.drp.vo.Shopcar;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IShopCarServiceFont {
    /**
     * 对购物车数据进行删除
     * @param mid   用户编号
     * @param gids  商品编号
     * @return
     * @throws SQLException
     */
    public boolean deleteByMember(String mid, Set<Long>gids) throws SQLException;

    /**
     * 进行数据库中购物车信息的鼻梁修改
     * @param cars
     * @return
     * @throws Exception
     */
    public boolean exitBatch(List<Shopcar> cars) throws Exception;
    /**
     * 根据用户的编号列出购物车之中的全部数据信息
     * @param mid
     * @return
     * @throws Exception
     */
    public Map<String,Object> listByMember(String mid) throws Exception;

    /**
     * 使用ajax异步进行调用购物车的增加，当点击增加商品的时候
     * 进行购物车的增加
     * @param vo
     * @return  成功与否
     * @throws SQLException
     */
    public boolean add(Shopcar vo) throws SQLException;
}
