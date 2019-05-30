package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IWarehouseDao;
import com.yootk.drp.service.back.IWarehouseServiceFront;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarehouseServiceImpl extends AbstractService implements IWarehouseServiceFront {

    @Autowired
    private IWarehouseDao warehouse;

    @Override
    public Map<String, Object> findSearchOrSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        if(keyWord==null ||"".equals(keyWord)){
            map.put("findSplit",this.warehouse.findSplit(currentPage,lineSize));
            map.put("countLike",this.warehouse.getAllCount(column,keyWord));
        }else {
            map.put("findSplit",this.warehouse.findSplit(currentPage,lineSize,column,keyWord));
            map.put("countLike",this.warehouse.getAllCount());
        }
        return map;
    }

    @Override
    public City findByCid(Long cid) throws SQLException {
        if(cid==null || "".equals(cid)){
            return null;
        }
        return this.warehouse.findByCid(cid);
    }

    @Override
    public boolean doCreate(Warehouse vo) throws SQLException {
        if(vo ==null ||"".equals(vo)){
            return false;
        }
        return this.warehouse.doCreate(vo);
    }

    @Override
    public List<Warehouse> findAll() throws SQLException {
        return this.warehouse.findAll();
    }

    @Override
    public Warehouse findByWiid() throws SQLException {
        return this.warehouse.findByAllWiid();
    }

    @Override
    public Warehouse findByWid(Long wid) throws SQLException {
        return this.warehouse.findById(wid);
    }

    @Override
    public boolean doEdit(Warehouse vo) throws SQLException {
        if(vo==null ||"".equals(vo)){
            return false;
        }
        return this.warehouse.doEdit(vo);
    }
}
