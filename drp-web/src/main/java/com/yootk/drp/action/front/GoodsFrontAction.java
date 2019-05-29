package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.service.front.IGoodsService;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsFrontAction extends AbstractAction{
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("goods_list")
    public void findAll() throws SQLException {
        ModuleAndView moduleAndView = new ModuleAndView();
        moduleAndView.add("goods",this.goodsService.findAll());
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
