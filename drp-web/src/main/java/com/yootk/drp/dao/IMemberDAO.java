package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;

public interface IMemberDAO extends IBaseDAO<String, Member> {
    /**
     * 在个人中心进行  编辑个人信息 (用户名称，电话，邮箱)
     * @param mid 当前用户的编号
     * @param name 修改后的名称
     * @param phone 修改后的电话
     * @param email 修改后的email
     * @return  成功返回true，否则返回false
     * @throws SQLException
     */
    public boolean doEditMessage(String mid,String name,String phone,String email) throws SQLException;

    /**
     * 根据用户编号获取已保存的密码
     * @param mid  当前用户的编号
     * @return  返回密码，在业务层进行密码校队
     * @throws SQLException
     */
    public String findByPassword(String mid) throws SQLException;

    /**
     * 原始密码校队正确，保存新密码
     * @param mid
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean doEditPassword(String mid,String password) throws SQLException;
}
