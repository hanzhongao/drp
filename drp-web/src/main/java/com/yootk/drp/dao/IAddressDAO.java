package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;
import java.util.List;

public interface IAddressDAO extends IBaseDAO<Long, Address> {
    public List<Address> findSplit(String mid, Long currentPage, Integer lineSize) throws SQLException;
    public List<Address> findSplit(String mid,Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException;
    public Long getAllCount(String mid) throws SQLException;
    public Long getAllCount(String mid,String column, String keyWord) throws SQLException;
    public Address findById(String mid) throws SQLException;
}
