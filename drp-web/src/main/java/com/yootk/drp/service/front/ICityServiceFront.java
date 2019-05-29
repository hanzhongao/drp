package com.yootk.drp.service.front;

import com.yootk.drp.vo.City;

import java.util.List;

public interface ICityServiceFront {
    /**
     *  根据指定省份编号，查询城市信息
     * @param pid
     * @return 城市列表
     * @throws Exception
     * @author 韩中傲
     */
    public List<City> findAllById(Long pid) throws Exception;
}
