package com.yootk.drp.service.back;

import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IGoodsServiceback {
    public Map<String,Object> addPre() throws SQLException;
    public boolean add(Goods good) throws SQLException;
    /**
     * 进行商品的查询
     * key=商品的一级分类 value=List查询到的数据
     * @return
     */
    public Map<String, List<Goods>> findAll() throws SQLException;
    public Map<String, Object> list(long currentPage, int lineSize, String column, String keyWord) throws Exception;
    public Map<String,Object> editPre(Long gid) throws SQLException;
    public boolean edit(Goods goods) throws SQLException;
    public Map<String,Object> findMessage(Long gid) throws SQLException;
    public String findPhotoById(Long gid) throws SQLException;
}
