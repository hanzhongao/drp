package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Subtype;

import java.sql.SQLException;
import java.util.List;

public interface ISubtypeDAO extends IBaseDAO<Long, Subtype> {
    public List<Subtype> findByIdWitem(Long wiid) throws SQLException;
}
