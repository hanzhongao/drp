package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IDeptDAO;
import com.yootk.drp.dao.ILevelDAO;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.service.front.IMemberServiceFront;
import com.yootk.drp.vo.Dept;
import com.yootk.drp.vo.Level;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceFrontImpl extends AbstractService implements IMemberServiceFront {
    @Autowired
    private IMemberDAO memberDAO;
    @Autowired
    private ILevelDAO levelDAO;
    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public boolean login(Member vo) throws SQLException {
        Member member = memberDAO.findById(vo.getMid());
        if (member != null) {
            return member.getPassword().equals(vo.getPassword());
        }
        return false;
    }


    @Override
    public boolean editMessage(String mid, String name, String phone, String email) throws Exception {
        if (name == "" || name.length() == 0 || phone == "" || phone.length() == 0 || email == "" || email.length() == 0) {
            return false;
        }
        return memberDAO.doEditMessage(mid, name, phone, email);
    }

    @Override
    public boolean editPassword(String mid, String newpassword) throws Exception {
        if(!(mid==""||"".equalsIgnoreCase(mid)||newpassword=="" ||"".equalsIgnoreCase(newpassword))){
            String newword = EncryptUtil.encode(newpassword);
            return memberDAO.doEditPassword(mid,newword);
        }
        return false;
    }

    @Override
    public boolean findPassWord(String mid, String oldpassword) throws Exception {
        if(!(mid==""||mid==null||oldpassword=="" ||oldpassword==null)){
            String password = memberDAO.findByPassword(mid);
            String oldword = EncryptUtil.encode(oldpassword);
            return password.equals(oldword);
        }
        return false;
    }

    @Override
    public boolean addMember(Member member) throws Exception {
        if (!(member.getMid() == ""|| "".equalsIgnoreCase(member.getMid()))){
            if (memberDAO.findById(member.getMid()) == null){
                member.setPassword(EncryptUtil.encode(member.getPassword()));
                return memberDAO.doCreate(member);
            }
        }
        return false;
    }

    @Override
    public Integer findTypeByMid(String mid) throws Exception {
        if (mid == "" || "".equals(mid)){
            return null;
        }
        return memberDAO.getTypeByMid(mid);
    }

    @Override
    public Map<String, Object> findMemberInfo(String mid) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        Member member = memberDAO.findById(mid);
        Dept dept = deptDAO.findById(member.getDid());
        Level level = levelDAO.findById(member.getLid());
        map.put("member",member);
        map.put("dept",dept);
        map.put("level",level);
        return map;
    }


}
