package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IGoodsDao;
import com.yootk.drp.dao.IShopCarDao;
import com.yootk.drp.service.front.IShopCarService;
import com.yootk.drp.vo.Goods;
import com.yootk.drp.vo.Shopcar;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author WangRan
 * 这是购物车业务实现
 */
@Service
public class ShopcatServiceFrontImpl extends AbstractService implements IShopCarService{
    @Autowired
    public IShopCarDao shopCarDao;

    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public boolean deleteByMember(String mid, Set<Long> gids) throws SQLException {
        if(gids ==null ||"".equals(gids)){
            return false;
        }
        return this.shopCarDao.doRemoveByMember(mid,gids);
    }

    @Override
    public boolean exitBatch(List<Shopcar> cars) throws Exception {
        if(cars ==null || cars.size()==0){
            return false;
        }
        return this.shopCarDao.doEditBatch(cars);
    }

    @Override
    public Map<String, Object> listByMember(String mid) throws Exception {
        Map<String,Object> result = new HashMap<>();
        Map<Long,Integer> shopcar = this.shopCarDao.findAllByMember(mid);
        List<Goods> allGoods = this.goodsDao.findAllByGods(shopcar.keySet());
        result.put("shopcar",shopcar);
        result.put("allGoods",allGoods);
        return result;
    }

    @Override
    public boolean add(Shopcar vo) throws SQLException {
        System.out.println(vo);
        Integer amount = this.shopCarDao.
                findAmountByMemberAndGoods(vo.getMid(),vo.getGid());
        if(amount==null){
            vo.setAmount(1);
            return this.shopCarDao.doCreate(vo);
        }else{
            amount++;
            return  this.shopCarDao.doEditAmonutByMemberAndGoods(vo.getMid(),vo.getGid(),amount);
        }
    }
}
