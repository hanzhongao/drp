package com.yootk.drp.service.front.impl;

import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.service.front.IMemberServiceFront;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;

public class MemberServiceFrontImpl extends AbstractService implements IMemberServiceFront {
    @Override
    public boolean login(Member vo) throws SQLException {
        return false;
    }
}
