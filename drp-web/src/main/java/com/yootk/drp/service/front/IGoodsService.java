package com.yootk.drp.service.front;

import com.yootk.common.annotation.Repository;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IGoodsService  {
    /**
     * 进行商品的查询
     * key=商品的一级分类 value=List查询到的数据
     * @return
     */
    public Map<String,List<Goods>> findAll() throws SQLException;
}
