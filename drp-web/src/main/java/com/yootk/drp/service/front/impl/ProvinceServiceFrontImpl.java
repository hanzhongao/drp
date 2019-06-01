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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,List<Province>> findAll() {
        Map<String,List<Province>> all = new HashMap<>();
        try {
            all.put("allProvince",this.provinceDAO.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Province findById(Long pid){
        try {
            return this.provinceDAO.findById(pid);
        }catch (Exception e){
            return null;
        }
    }
}
