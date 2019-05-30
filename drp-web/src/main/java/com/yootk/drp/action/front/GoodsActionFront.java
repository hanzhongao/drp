package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.front.IGoodsServiceFont;

import java.sql.SQLException;

@Controller
public class GoodsActionFront extends AbstractAction{
    @Autowired
    private IGoodsServiceFont goodsService;

    @RequestMapping("/goods_list")
    public void findAll() throws SQLException {
        ModuleAndView moduleAndView = new ModuleAndView();
        moduleAndView.add("goods",this.goodsService.findAll());
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
