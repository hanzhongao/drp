package com.yootk.drp.service.back;

import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IWarehouseServiceFront {
    /**
     * 进行商品仓库的增加
     * @param vo    Warehouse
     * @return  成功与否
     * @throws SQLException
     */
    public boolean doCreate(Warehouse vo) throws SQLException;

    /**
     * 查询全部的商品仓库信息
     *
     * @return Map key=String value=Object
     */
    public List<Warehouse> findAll() throws SQLException;

    /**
     * 查询全部的商品id信息
     * @return
     * @throws SQLException
     */
    public Warehouse findByWiid() throws SQLException;

    /**
     * 根据商品id查询全部的商品进行修改商品时候的信息回填
     * @return
     * @throws SQLException
     */
    public Warehouse findByWid(Long wid) throws SQLException;

    /**
     * 根据CID查询全部的城市信息
     * @param cid
     * @return
     * @throws SQLException
     */
    public City findByCid(Long cid) throws SQLException;

    /**
     * 对仓库进行增删改查。此操作为改
     * @param vo
     * @return
     */
    public boolean doEdit(Warehouse vo) throws SQLException;

    /**
     * 用户模糊查询以及分页的方法
     * @return  4个方法的调用  split（2个分页+模糊） count(分页+模糊)
     */
    public Map<String,Object> findSearchOrSplit(Long currentPage,Integer lineSize,String column,String keyWord) throws SQLException;
}
