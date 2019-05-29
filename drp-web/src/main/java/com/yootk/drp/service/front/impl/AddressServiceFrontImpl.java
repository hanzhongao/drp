package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IAddressDAO;
import com.yootk.drp.service.front.IAddressServiceFront;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;


@Service
public class AddressServiceFrontImpl extends AbstractService implements IAddressServiceFront {
    @Autowired
    private IAddressDAO iAddressDAO;
    @Override
    public boolean add(Address address) throws SQLException {
        if (!(address == null || "".equalsIgnoreCase(address.toString()))){
            return this.iAddressDAO.doCreate(address);
        }
        return false;
    }
}
