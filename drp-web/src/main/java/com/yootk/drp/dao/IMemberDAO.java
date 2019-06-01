package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.List;

public interface IMemberDAO extends IBaseDAO<String, Member> {
    /**
     * 在个人中心进行  编辑个人信息 (用户名称，电话，邮箱)
     *
     * @param mid   当前用户的编号
     * @param name  修改后的名称
     * @param phone 修改后的电话
     * @param email 修改后的email
     * @return 成功返回true，否则返回false
     * @throws SQLException
     */
    public boolean doEditMessage(String mid, String name, String phone, String email) throws SQLException;

    /**
     * 根据用户编号获取已保存的密码
     *
     * @param mid 当前用户的编号
     * @return 返回密码，在业务层进行密码校队
     * @throws SQLException
     */
    public String findByPassword(String mid) throws SQLException;

    /**
     * 原始密码校队正确，保存新密码
     *
     * @param mid
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean doEditPassword(String mid, String password) throws SQLException;

    /**
     * 根据用户类型（用户或雇员）查询 用户
     * @return 用户列表
     * @throws SQLException
     */
    public List<Member> findAllByType() throws SQLException ;

    /**
     * 进行数据表的数据量的模糊统计
     * @param column 要执行模糊查询的数据列
     * @param keyWord 要执行模糊查询的关键字
     * @return SQL语句中COUNT()函数的返回结果
     * @throws SQLException 数据库执行异常
     */
    public Long getCountByType(String column, String keyWord) throws SQLException ;

    /**
     * 进行数据表的数据量的模糊统计
     * @return SQL语句中COUNT()函数的返回结果
     * @throws SQLException 数据库执行异常
     */
    public Long getCountByType() throws SQLException ;

    /**
     * 修改用户类型
     * @param mid 用户mid
     * @param type 用户类型 0：前端用户 1：后台雇员
     * @return 修改成功返回true,修改失败返回false
     * @throws SQLException
     * @author hanzhongao
     */
    public boolean doEditType(String mid ,Integer type) throws SQLException ;
}
