package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.*;
import com.yootk.drp.service.front.IOrdersServiceFront;
import com.yootk.drp.vo.Address;
import com.yootk.drp.vo.Details;
import com.yootk.drp.vo.Goods;
import com.yootk.drp.vo.Orders;

import java.util.*;

@Service
public class OrdersServiceFrontImpl extends AbstractService implements IOrdersServiceFront {

    @Autowired
    private IShopCarDao shopCarDao ;

    @Autowired
    private IGoodsDao goodsDao ;

    @Autowired
    private IAddressDAO addressDAO ;

    @Autowired
    private IProvinceDAO provinceDAO ;

    @Autowired
    private IOrdersDAO ordersDAO ;

    @Autowired
    private IDetailsDAO detailsDAO ;

    @Override
    public Map<String, Object> preAdd(String mid, Set<Long> gids) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        Map<Long,Integer> shopcar = this.shopCarDao.findAllByMember(mid) ;  //列出该用户的购物车的全部信息
        List<Goods> allGoods = this.goodsDao.findAllByGods(gids) ;  //列出所有商品信息
        List<Address> allAddresses = this.addressDAO.findAddressByMember(mid) ; //列出该用户所有地址信息*/
        result.put("shopcar",shopcar) ;
        result.put("allGoods",allGoods) ;
        result.put("allAddresses",allAddresses) ;
        return result;
    }

    @Override
    public boolean add(Orders orders, Set<Long> gids) throws Exception {
        // 1、将当前的日期设置为订单的创建日期；
        orders.setSubdata(new Date());  // 将当前日期设置为订单日期
        double sum = 0.0 ; // 进行商品总价的保存
        int amount = 0 ;    //商品总数的保存
        // 2、获取订单对应的所有商品数据，利用商品数据可以计算总价
        List<Goods> allGoods = this.goodsDao.findAllByGods(gids) ;
        Map<Long,Integer> shopcar = this.shopCarDao.findAllByMember(orders.getMid()) ; // 获取当前用户的购物车内容
        for (Goods goods : allGoods) {
            sum += goods.getPrice() * shopcar.get(goods.getGid()) ; // 商品单价 * 商品数量
            amount += shopcar.get(goods.getGid());
        }
        // 3、将总价和数量的信息保存在Orders对象之中
        orders.setPrice(sum);
        orders.setAdid(amount);
        // 4、进行订单的数据存储
        if (this.ordersDAO.doCreate(orders)) {  // 创建订单
            Long oid = this.ordersDAO.findLastId() ; // 获取当前的订单id
            List<Details> allDetails = new ArrayList<>() ;
            for (Long gid : gids) { // 创建订单详情内容
                Details det = new Details() ;
                det.setOid(oid);    // 保存订单编号
                det.setGid(gid);    // 保存订单商品编号
                det.setAmount(shopcar.get(gid)); // 获取商品数量
                allDetails.add(det) ;
            }
            // 5、将所有的订单详情的内容进行存储
            if (this.detailsDAO.doCreateBatch(allDetails)) {    // 订单详情保存成功
                // 6、删除购物车中的相应数据
                return this.shopCarDao.doRemoveByMember(orders.getMid(),gids) ;
            }
        }
        return false;
    }
}
