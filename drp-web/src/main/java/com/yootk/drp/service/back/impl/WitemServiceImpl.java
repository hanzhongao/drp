package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IWitemDao;
import com.yootk.drp.service.back.IWitemServiceFront;
import com.yootk.drp.vo.Witem;

import java.sql.SQLException;
import java.util.List;

@Service
public class WitemServiceImpl extends AbstractService implements IWitemServiceFront {
    @Autowired
    public IWitemDao witemDao;
    @Override
    public List<Witem> findAll() throws SQLException {
        return this.witemDao.findAll();
    }
}
