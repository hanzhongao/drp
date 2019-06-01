package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public interface IAddressDAO extends IBaseDAO<Long, Address> {
    public List<Address> findSplit(String mid, Long currentPage, Integer lineSize) throws SQLException;

    public List<Address> findSplit(String mid, Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException;

    public Long getAllCount(String mid) throws SQLException;

    public Long getAllCount(String mid, String column, String keyWord) throws SQLException;

    public Address findById(Long aLong) throws SQLException;
    /**
     * 根据用户编号查询该用户所有地址信息（这里可以查customer表，也可以查Address表）
     * @param mid   用户id
     * @return  返回该用户的 list地址集合
     * @throws SQLException
     */
    public List<Address> findAddressByMember(String mid) throws SQLException;

    public boolean doRemoveByMemberAndAdid(String mid, Set<Integer> adids) throws SQLException;
}

