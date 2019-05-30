package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.ICustomerDAO;
import com.yootk.drp.service.front.IPurchaseServiceFront;
import com.yootk.drp.vo.Customer;

import java.sql.SQLException;

/**
 * @author yaoxinlan
 */
@Service
public class PurchaseServiceFrontImpl extends AbstractService implements IPurchaseServiceFront {
    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public boolean isAuthencation(String mid) throws SQLException {
        Customer customer = customerDAO.getCInfo(mid);
        if (customer == null) {
            return false;
        } else {
            if (customer.getStatus() == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
