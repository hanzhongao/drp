package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.ICityDAO;
import com.yootk.drp.service.front.ICityServiceFront;
import com.yootk.drp.vo.City;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceFrontImpl extends AbstractService implements ICityServiceFront {

    @Autowired
    private ICityDAO cityDAO ;
    @Override
    /**
     * 根据省份边好，查询该省下的所有城市
     * @author 韩中傲
     */
    public List<City> findAllById(Long pid) throws Exception {
        if(pid == null || "".equals(pid)){
            return null;
        }
        return this.cityDAO.findByPid(pid) ;
    }
}
