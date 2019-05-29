package com.yootk.drp.service.front;

import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IAddressServiceFront  {
    public boolean add(Address address) throws Exception;
    public Map<String, Object> list(String mid,long currentPage, int lineSize, String column, String keyWord) throws Exception;
    public Address findById(Long adid) throws Exception;
    public boolean editById(Address address) throws Exception;
}
