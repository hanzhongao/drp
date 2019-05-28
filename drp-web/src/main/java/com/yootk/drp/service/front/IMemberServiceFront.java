package com.yootk.drp.service.front;

import com.yootk.drp.vo.Member;

import java.sql.SQLException;

public interface IMemberServiceFront {
    /**
     * 用户登录处理类
     * @param vo 登陆的用户
     * @return  登录成功返回true，失败返回false
     * @throws SQLException
     */
    public boolean login(Member vo) throws SQLException;
}
