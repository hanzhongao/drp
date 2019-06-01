package com.yootk.drp.service.front;

import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.Map;

public interface IMemberServiceFront {
    /**
     * 用户登录处理类
     * @param vo 登陆的用户
     * @return  登录成功返回true，失败返回false
     * @throws SQLException
     */
    public boolean login(Member vo) throws SQLException;
    /**
     * 个人信息（名称，电话，邮箱）的编辑修改
     * @param mid  当前用户编号
     * @param name 修改后的名称
     * @param phone 修改后的电话
     * @param email 修改后的邮箱
     * @return  修改成功返回true
     * @throws Exception
     */
    public boolean editMessage(String mid,String  name,String phone,String email) throws Exception;

    /**
     *
     * @param mid
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws Exception
     */
    public boolean editPassword(String mid,String oldPassword,String newPassword) throws Exception;

}
