package com.yootk.drp.service.back;

import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

public interface IWarehouseServiceFront {
    /**
     * 进行商品仓库的增加
     * @param vo    Warehouse
     * @return  成功与否
     * @throws SQLException
     */
    public boolean doCreate(Warehouse vo) throws SQLException;
}
