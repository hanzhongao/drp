package com.yootk.drp.service.back;

import com.yootk.drp.vo.Member;

import java.util.Map;

public interface IMemberServiceBack {
    /**
     * 实现雇员数据增加前的数据查询操作，该操作需要查询出所有的部门信息和职位信息；
     * @return 返回有如下的数据内容：
     * 1、key = allDepts、 value = 部门List集合；
     * 2、key = allLevels、value = 职位List集合；
     * @throws Exception 数据层异常
     * @author 韩中傲
     */
    public Map<String,Object> preAdd() throws Exception ;

    /**
     * 实现雇员信息的保存
     * @param member 保存数据的VO对象
     * @return 如果保存成功返回true，否则返回false
     * @throws Exception 数据层异常
     * @author 韩中傲
     */
    public boolean add(Member member) throws Exception ;

    /**
     * 进行雇员信息的列表显示，在列表的同时需要显示出职位信息以及部门的信息
     * @param currentPage 当前所在页面
     * @param lineSize 每页显示的数据行
     * @param column 模糊查询列
     * @param keyWord 查询关键字
     * @return 对于本次的查询需要包含有如下的几个内容：
     * 1、key = allMembers、value = List集合；
     * 2、key = allRecorders、value = 表中的整体记录的个数；
     * 3、key = allDepts、value = Map集合（key = did、value = dname）
     * 4、key = allLevels、value = Map集合（key = lid、value = title）
     * @throws Exception  数据层异常
     * @author hanzhongao
     */
    public Map<String,Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception ;

    /**
     * 实现雇员数据修改前的数据查询操作，该操作需要查询出所有的部门信息、职位信息以及雇员信息；
     * @param mid 雇员编号，查询此编号的雇员信息
     * @return 返回以下内容：
     * 1、key = allDepts、 value = 部门List集合；
     * 2、key = allLevels、value = 职位List集合；
     * 3、key = member、   value = 要修改的雇员信息。
     * @throws Exception 数据层异常
     * @author hanzhongao
     */
    public Map<String,Object> preEdit(String mid) throws Exception ;


    /**
     * 实现雇员信息的更新，该雇员信息必须保证所属的部门有名额，同时设置的工资与岗位工资相匹配
     * @param member 保存数据的VO对象
     * @return 如果保存成功返回true，否则返回false
     * @throws Exception 数据层异常
     * @author hanzhongao
     */
    public boolean edit(Member member) throws Exception ;
}
