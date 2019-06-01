package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.ISubtypeDAO;
import com.yootk.drp.dao.IWitemDao;

import com.yootk.drp.service.back.ISubtypeServiceback;
import com.yootk.drp.vo.Subtype;

import java.sql.SQLException;
import java.util.List;

@Service
public class SubtypeServicebackImpl extends AbstractService implements ISubtypeServiceback {
    @Autowired
    private ISubtypeDAO subtypeDAO;

    @Override
    public List<Subtype> findAllById(Long wiid) throws SQLException {
        return subtypeDAO.findByIdWitem(wiid);
    }
}
