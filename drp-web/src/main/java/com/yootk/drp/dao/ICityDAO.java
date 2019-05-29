package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<Long, City> {
    /**
     * 根据省份编号查找相应的城市信息
     * @param pid   省份编号
     * @return      返回对于的城市内容集合
     * @throws SQLException JDBC
     */
    public List<City> findCityByProvince(Long pid)throws SQLException ;
}
