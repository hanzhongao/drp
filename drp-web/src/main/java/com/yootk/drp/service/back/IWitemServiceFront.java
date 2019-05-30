package com.yootk.drp.service.back;


import com.yootk.drp.vo.Witem;

import java.sql.SQLException;
import java.util.List;

public interface IWitemServiceFront {
    /**
     * 查询全部的商品仓库所属分类信息
     * @return
     */
    public List<Witem> findAll() throws SQLException;

    /**
     * 根据商品仓库的类型id去查询对应的商品仓库类型
     * @param wwid
     * @return     商品仓库的类型
     */
    public Witem findByTile(Long wwid) throws SQLException;
}
