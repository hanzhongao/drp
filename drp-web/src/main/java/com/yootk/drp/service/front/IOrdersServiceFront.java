package com.yootk.drp.service.front;

import com.yootk.drp.vo.Orders;

import java.util.Map;
import java.util.Set;

public interface IOrdersServiceFront {
    /**
     * 创建订单前，根据用户编号，商品编号集合，查询用户地址
     * @param mid   用户编号
     * @param gids  商品编号
     * @return      返回Map集合
     * 1、key=shoppcar，value=(Map)商品编号和购买数量的对应关系
     * 2、key=allGoods,value=(list)所有要购买的商品信息
     * 3、key=allAddresses,value=(list)用户的所有地址信息
     * @throws Exception
     */
    public Map<String,Object> preAdd(String mid, Set<Long> gids) throws Exception;

    /**
     * 实现用户订单创建，有如下操作
     * 1、订单创建日期，为当前日期
     * 2、订单总价要通过购物车商品数量和商品单价计算
     * 3、订单信息保存，返回当前订单id
     * 4、利用此订单id创建相应的Details实例，将其保存在数据库里面
     * 5、删除相应购物车数据信息
     * @param orders    要创建的订单基本信息
     * @param gids  订单包含的商品信息
     * @return  创建成功返回true
     * @throws Exception    数据层异常
     */
    public boolean add(Orders orders,Set<Long> gids) throws Exception ;
}
