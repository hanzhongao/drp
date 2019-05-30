package com.yootk.drp.service.front;

import java.sql.SQLException;

/**
 * @author yaoxinlan
 */
public interface IPurchaseServiceFront {
    public boolean isAuthencation(String mid) throws SQLException;
}
