package com.yootk.drp.service.front;

import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProvinceServiceFront {
    public Map<String,List<Province>> findAll() throws SQLException;
    public Province findById(Long pid) throws SQLException;
}
