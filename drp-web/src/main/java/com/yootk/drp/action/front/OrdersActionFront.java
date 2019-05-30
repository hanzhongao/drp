package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.front.IOrdersServiceFront;
import com.yootk.drp.vo.Orders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ${hutao}
 * @create 2019/5/28 9:58
 */

@Controller
@RequestMapping("/pages/front/center/orders/")
public class OrdersActionFront extends AbstractAction {
    public static final String ACTION_TITLE="订单";
    //public static final Set<Long> gidSet = new HashSet<>() ;
    @Autowired
    private IOrdersServiceFront ordersServiceFront ;

    /**
     * 实现订单创建处理
     *
     * @return 订单创建页面
     */
    @RequestMapping("orders_add")
    public ModuleAndView add(Orders orders,Long[] gid) {
        orders.setMid(super.getFrontUser()); // 设置订单所属于的用户
        Set<Long> gidSet = new HashSet<>() ;
        gidSet.addAll(Arrays.asList(gid)); // 将数组通过List添加到Set之中
        System.out.println("orders == " + orders + "、gid = " + gidSet);
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        try {
            if (this.ordersServiceFront.add(orders, gidSet)) {    // 进行数据保存
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.failure", ACTION_TITLE));
            }
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        } catch (Exception e) {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        }
        return mav;
    }

    /**
     * 实现订单创建前的处理
     * @return 订单创建页面
     */
    @RequestMapping("orders_add_pre")
    public ModuleAndView addPre(Long[] gid) {
        if(gid ==null ||gid.length==0){
            return null;
        }
        Set<Long> gidSet = new HashSet<>() ;
        gidSet.addAll(Arrays.asList(gid)) ; // 将数组通过List添加到Set之中
        if(gidSet == null || gidSet.size() == 0){

        }
        ModuleAndView mav = new ModuleAndView(super.getPage("add.page")) ;
        try {
            mav.add(this.ordersServiceFront.preAdd(super.getFrontUser(),gidSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    /**
     * 查看订单详情信息
     * @return 订单详情显示
     */
    @RequestMapping("orders_details_show")
    public ModuleAndView show() {
        ModuleAndView mav = new ModuleAndView(super.getPage("show.page")) ;
        return mav ;
    }


    /**
     * 实现订单信息列表显示
     * @return 跳转到订单列表页
     */
    @RequestMapping("orders_list")
    public ModuleAndView list() {
        ModuleAndView mav = new ModuleAndView(super.getPage("list.page")) ;
        return mav ;
    }

    @Override
    public String getUploadDir() {
        return "/upload/orders";
    }
}
