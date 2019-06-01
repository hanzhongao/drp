package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Level;

import java.sql.SQLException;
import java.util.Map;

public interface ILevelDAO extends IBaseDAO<Long, Level> {
    /**
     * 查询出所有的职位信息，其中职位编号保存在key中，职位名称保存在value中
     * @return 保存职位信息的集合
     * @throws SQLException JDBC异常
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
