package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.ILevelDAO;
import com.yootk.drp.vo.Level;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class LevelDAOImpl extends AbstractDAO implements ILevelDAO {
    @Override
    public boolean doCreate(Level level) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Level level) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    /**
     * 根据数据表的ID主键进行指定数据信息的获取
     *
     * @param id 要查询的数据ID
     * @return 如果数据存在，则数据以VO的形式返回，如果数据不存在返回null
     * @throws SQLException 数据库执行异常
     */
    @Override
    public Level findById(Long id) throws SQLException {
        String sql = "select lid,title from level where lid = ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, id);
        return super.handleResultToVO(super.pstmt.executeQuery(),Level.class);
    }

    /**
     * 查询全部职务
     *
     * @return 返回职务信息列表
     * @throws SQLException
     * @author hanzhongao
     */
    @Override
    public List<Level> findAll() throws SQLException {
        String sql = "select lid,title from level";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Level.class);
    }

    @Override
    public List<Level> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Level> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Map<Long, String> findAllMap() throws SQLException {
        Map<Long, String> map = new HashMap<>();
        String sql = "SELECT lid,title FROM level";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            map.put(rs.getLong(1), rs.getString(2));
        }
        return map;
    }
}

