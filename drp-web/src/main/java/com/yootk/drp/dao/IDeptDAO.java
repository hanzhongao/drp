package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Dept;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDeptDAO extends IBaseDAO<Long, Dept> {

    /**
     * 查询出所有的部门信息，其中部门编号保存在key中，部门名称保存在value中
     * @return 保存部门信息的集合
     * @throws SQLException JDBC异常
     */
    public Map<Long,String> findAllMap() throws SQLException ;

}
