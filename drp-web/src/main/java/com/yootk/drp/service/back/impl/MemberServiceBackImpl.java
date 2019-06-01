package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IDeptDAO;
import com.yootk.drp.dao.ILevelDAO;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.service.back.IMemberServiceBack;
import com.yootk.drp.vo.Dept;
import com.yootk.drp.vo.Level;
import com.yootk.drp.vo.Member;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceBackImpl extends AbstractService implements IMemberServiceBack {

    @Autowired
    private IMemberDAO memberDAO;

    @Autowired
    private IDeptDAO deptDAO ;

    @Autowired
    private ILevelDAO levelDAO ;

    /**
     * 实现雇员数据增加前的数据查询操作，该操作需要查询出所有的部门信息和职位信息；
     * @return 返回有如下的数据内容：
     * 1、key = allDepts、 value = 部门List集合；
     * 2、key = allLevels、value = 职位List集合；
     * @throws Exception 数据层异常
     * @author hanzhongao
     */
    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allDepts",this.deptDAO.findAll()) ;
        map.put("allLevels",this.levelDAO.findAll()) ;
        return map;
    }

    /**
     * 实现雇员信息的保存，如果用户已存在，则只修改用户类型 0: 普通用户 1：雇员
     * @param member 保存数据的VO对象
     * @return 如果保存成功返回true，否则返回false
     * @throws Exception 数据层异常
     * @author 韩中傲
     */
    @Override
    public boolean add(Member member) throws Exception {
        Member memberExists = this.memberDAO.findById(member.getMid()) ; // 数据库中已存在的用户
        if (memberExists != null) { // 用户已存在
            if (memberExists.getType() == 0) { // 如果这是一个普通用户
                if (this.memberDAO.doEditType(member.getMid(),1)) { // 将用户类型修改为雇员 type=1 ;
                    return this.memberDAO.doEdit(member); // 修改雇员信息
                }
            } else {
                // 如果用户是雇员，不在添加直接退出
                return false ;
            }
        }
        if (this.memberDAO.doCreate(member)) { // 如果用户添加成功
            // 修改用户类型  0: 普通用户 1：雇员
           return this.memberDAO.doEditType(member.getMid(),1) ;
        }
        return false ;
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        if (super.isEmpty(column,keyWord)) {    // 有内容为null，查询全部
            map.put("allMembers",this.memberDAO.findSplit(currentPage,lineSize)) ;
            map.put("allRecorders",this.memberDAO.getCountByType()) ;
        } else {
            map.put("allMembers",this.memberDAO.findSplit(currentPage,lineSize,column,keyWord)) ;
            map.put("allRecorders",this.memberDAO.getCountByType(column,keyWord)) ;
        }
        map.put("allDepts",this.deptDAO.findAllMap()) ;
        map.put("allLevels",this.levelDAO.findAllMap()) ;
        return map ;
    }

    @Override
    public Map<String, Object> preEdit(String mid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("allDepts",this.deptDAO.findAll()) ;      // 1、key = allDepts、 value = 部门List集合；
        map.put("allLevels",this.levelDAO.findAll()) ;    // 2、key = allLevels、value = 职位List集合；
        map.put("member",this.memberDAO.findById(mid)) ;  // 3、key = member、   value = 要修改的雇员信息。
        return map;
    }

    @Override
    public boolean edit(Member member) throws Exception {
        return this.memberDAO.doEdit(member);
    }
}
