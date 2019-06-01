package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Details;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author ${hutao}
 * @create 2019/5/29 9:43
 */
public interface IDetailsDAO extends IBaseDAO<Long, Details> {
    /**
     * 创建订单详情
     * @param allDetails
     * @return
     * @throws SQLException
     */
    public boolean doCreateBatch(List<Details> allDetails) throws SQLException ;
}
