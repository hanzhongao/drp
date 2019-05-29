package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Orders;

import java.sql.SQLException;

/**
 * @Author ${hutao}
 * @create 2019/5/29 9:31
 */
public interface IOrdersDAO extends IBaseDAO<Long, Orders> {
    /**
     * 查询订单最后一次增长id
     * @return
     * @throws SQLException
     */
    public Long findLastId() throws SQLException ;
}
