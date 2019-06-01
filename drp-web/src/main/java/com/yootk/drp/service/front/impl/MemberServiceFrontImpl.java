package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
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
    public boolean editPassword(String mid, String oldPassword, String newPassword) throws Exception {
        if (!(oldPassword == "" || oldPassword.length() == 0 || oldPassword == "" || oldPassword.length() == 0)) {
            if (memberDAO.findByPassword(mid) == oldPassword) {
                return memberDAO.doEditPassword(mid, newPassword);
            }
        }
        return false;
    }


}
