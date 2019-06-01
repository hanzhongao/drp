package com.yootk.drp.service.back;

import com.yootk.drp.vo.Subtype;

import java.sql.SQLException;
import java.util.List;

public interface ISubtypeServiceback  {
    public List<Subtype> findAllById(Long wiid) throws SQLException;
}
