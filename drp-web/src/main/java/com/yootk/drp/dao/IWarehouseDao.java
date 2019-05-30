package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

public interface IWarehouseDao extends IBaseDAO<Long, Warehouse> {
    /**
     *  查询商品信息仓库里面所有的Wiid，
     * @return  只返回一个Wiid
     */
    public Warehouse findByAllWiid() throws SQLException;

    /**
     * 根据想要修改的仓库的cid 查询所有的城市信息
     * @param cid
     * @return
     */
    public City findByCid(Long cid) throws SQLException;
}
