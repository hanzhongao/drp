package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IGoodsDao;
import com.yootk.drp.service.front.IGoodsServiceFont;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceFrontImpl extends AbstractService implements IGoodsServiceFont {
    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public Map<String, List<Goods>> findAll() throws SQLException {
        Map<String,List<Goods>> map = new HashMap<>();
        map.put("findAll",this.goodsDao.findAll());
        return map;
    }
}
