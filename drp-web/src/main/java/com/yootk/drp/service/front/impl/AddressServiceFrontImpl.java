package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IAddressDAO;
import com.yootk.drp.dao.ICityDAO;
import com.yootk.drp.dao.IProvinceDAO;
import com.yootk.drp.service.front.IAddressServiceFront;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Service
public class AddressServiceFrontImpl extends AbstractService implements IAddressServiceFront {
    @Autowired
    private IAddressDAO iAddressDAO;
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private ICityDAO cityDAO;
    @Override
    public Map<String, Object> addPre() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("allProvince",this.provinceDAO.findAll());
        return map;
    }

    @Override
    public boolean deleteByAdid(String mid, Set<Integer> adids) throws Exception {
        if (adids == null || adids.size() == 0){
            return false;
        }
        return this.iAddressDAO.doRemoveByMemberAndAdid(mid,adids);
    }

    @Override
    public Map<String, Object> editPre(Long adid) throws SQLException {
        Address address = iAddressDAO.findById(adid);
        Map<String,Object> map = new HashMap<>();
        map.put("address",address);
        map.put("allProvince",provinceDAO.findAll());
        map.put("allCity",cityDAO.findAll());
        return map;
    }

    @Override
    public boolean edit(Address address) throws SQLException {
        return this.iAddressDAO.doEdit(address);

    }

    @Override
    public boolean add(Address address) throws SQLException {
        if (!(address == null || "".equalsIgnoreCase(address.toString()))){
            return this.iAddressDAO.doCreate(address);
        }
        return false;
    }

    @Override
    public Map<String, Object> list(String mid,long currentPage, int lineSize, String column, String keyWord) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (super.isEmpty(column, keyWord)) { // 不需要进行模糊查询
            map.put("allAddress", this.iAddressDAO.findSplit(mid,currentPage, lineSize));
            map.put("allRecorders", this.iAddressDAO.getAllCount(mid));
        } else {
            map.put("allAddress", this.iAddressDAO.findSplit(mid,currentPage, lineSize, column, keyWord));
            map.put("allRecorders", this.iAddressDAO.getAllCount(mid,column, keyWord));
        }
        return map;
    }
    public Address findById(Long adid) throws Exception{
        //Long id = Long.parseLong(mid);

        return this.iAddressDAO.findById(adid);
    }
    public boolean editById(Address address) throws Exception{
        return this.iAddressDAO.doEdit(address);
    }


}
