package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Customer;

import java.sql.SQLException;

/**
 * @author yaoxinlan
 */
public interface ICustomerDAO extends IBaseDAO<String, Customer> {
    public Customer getCInfo(String mid) throws SQLException;
}
