package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author ${hutao}
 * @create 2019/5/28 10:36
 */
public interface IAddressDAO extends IBaseDAO<Long, Address> {
    /**
     * 根据用户编号查询该用户所有地址信息（这里可以查customer表，也可以查Address表）
     * @param mid   用户id
     * @return  返回该用户的 list地址集合
     * @throws SQLException
     */
   public List<Address> findAddressByMember(String mid) throws SQLException ;

}
