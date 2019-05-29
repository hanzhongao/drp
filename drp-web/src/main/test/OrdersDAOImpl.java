import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IOrdersDAO;
import com.yootk.drp.vo.Orders;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Author ${hutao}
 * @create 2019/5/29 9:34
 */
@Repository
public class OrdersDAOImpl extends AbstractDAO implements IOrdersDAO {
    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }

    @Test
    public void testCreate() throws SQLException {
        Orders oders = new Orders() ;
        oders.setMid("aaaa");
        oders.setPrice(887.0);
        oders.setSubdata(new Date());
        oders.setText("adfafd");
        oders.setAdid(9);
        System.out.println(this.doCreate(oders)) ;
    }

    @Override
    public boolean doCreate(Orders orders) throws SQLException {
        System.out.println("数据层" + orders);
        String sql = "INSERT INTO orders(mid,adid,subdate,price,note) VALUES (?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        System.out.println(sql);
        super.pstmt.setString(1,orders.getMid());
        super.pstmt.setInt(2,orders.getAdid());
        super.pstmt.setDate(3,new java.sql.Date(orders.getSubdata().getTime()));
        super.pstmt.setDouble(4,orders.getPrice());
        super.pstmt.setString(5,orders.getText());
        //System.out.println(super.pstmt.executeUpdate() > 0);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Orders orders) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Orders findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
}
