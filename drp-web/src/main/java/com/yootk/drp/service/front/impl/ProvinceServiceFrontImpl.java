package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Repository;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IProvinceDAO;
import com.yootk.drp.service.front.IProvinceServiceFront;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceFrontImpl extends AbstractService implements IProvinceServiceFront {

    @Autowired
    private IProvinceDAO provinceDAO ;

    /**
     *  查询所有省份信息
     * @return 省份列表
     * @authoer 韩中傲
     */
    @Override
    public List<Province> findAll() {
        try {
            return this.provinceDAO.findAll() ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
