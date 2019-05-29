package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<Long, City> {
    /**
     * 按照省份查询城市信息
     * @param pid  省份编号
     * @return 城市列表
     * @throws SQLException
     * @auther 韩中傲
     */
    public List<City> findByPid(Long pid) throws SQLException ;
}
