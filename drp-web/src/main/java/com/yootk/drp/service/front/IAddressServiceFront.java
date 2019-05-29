package com.yootk.drp.service.front;

import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;

public interface IAddressServiceFront  {
    public boolean add(Address address) throws SQLException;
}
