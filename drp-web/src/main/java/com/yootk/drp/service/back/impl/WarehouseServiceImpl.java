package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IWarehouseDao;
import com.yootk.drp.service.back.IWarehouseServiceFront;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

@Service
public class WarehouseServiceImpl extends AbstractService implements IWarehouseServiceFront {

    @Autowired
    private IWarehouseDao warehouse;

    @Override
    public boolean doCreate(Warehouse vo) throws SQLException {
        if(vo ==null ||"".equals(vo)){
            return false;
        }
        return this.warehouse.doCreate(vo);
    }
}
