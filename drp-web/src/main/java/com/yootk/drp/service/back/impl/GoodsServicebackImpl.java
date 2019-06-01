package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IGoodsDAO;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.dao.ISubtypeDAO;
import com.yootk.drp.dao.IWitemDao;
import com.yootk.drp.service.back.IGoodsServiceback;
import com.yootk.drp.vo.Goods;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServicebackImpl extends AbstractService implements IGoodsServiceback {
    @Autowired
    private IGoodsDAO goodsDao;
    @Autowired
    private IWitemDao witemDao;
    @Autowired
    private ISubtypeDAO subtypeDAO;
    @Autowired
    private IMemberDAO memberDAO;
    @Override
    public Map<String, Object> addPre() throws SQLException {
        Map<String,Object> map = new HashMap<>();
        map.put("allWitem",this.witemDao.findAll());
        return map;
    }

    @Override
    public boolean add(Goods good) throws SQLException {
        if (good !=null){
            Date date = new Date();
            good.setLastin(new Timestamp(date.getTime()));
            return goodsDao.doCreate(good);
        }
        return false;
    }

    @Override
    public Map<String, List<Goods>> findAll() throws SQLException {
        Map<String,List<Goods>> map = new HashMap<>();
        map.put("findAll",this.goodsDao.findAll());
        return map;
    }

    @Override
    public Map<String, Object> list( long currentPage, int lineSize, String column, String keyWord) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
//        Map<String,Object> mem = new HashMap<>();
//        for (Member member : this.memberDAO.findAll()){
//            mem.put(member.getMid(),member.getName());
//        }
//        map.put("allMemberMap",mem);
        if (super.isEmpty(column, keyWord)) { // 不需要进行模糊查询
            map.put("allGoods", this.goodsDao.findSplit(currentPage, lineSize));
            map.put("allRecorders", this.goodsDao.getAllCount());
        } else {
            map.put("allGoods", this.goodsDao.findSplit(currentPage, lineSize, column, keyWord));
            map.put("allRecorders", this.goodsDao.getAllCount(column, keyWord));
        }
        return map;
    }

    @Override
    public Map<String, Object> editPre(Long gid) throws SQLException {
        Goods goods = goodsDao.findById(gid);
        Map<String,Object> map = new HashMap<>();
        map.put("goods",goodsDao.findById(gid));
        map.put("allWitems",this.witemDao.findAll());
        map.put("allSubtypes",subtypeDAO.findByIdWitem(goods.getWiid()));
        return map;
    }

    @Override
    public boolean edit(Goods goods) throws SQLException {
        return goodsDao.doEdit(goods);
    }

    @Override
    public Map<String, Object> findMessage(Long gid) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        map.put("good",goodsDao.findById(gid));
        //System.out.println("*******************"+map.get("good"));
        //map.put("",);    查入库次数
        return map;
    }

    @Override
    public String findPhotoById(Long gid) throws SQLException {
        if (gid == null){
            return null;
        }
        return this.goodsDao.findPhotoById(gid);
    }
}
