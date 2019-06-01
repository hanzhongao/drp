package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.front.IShopCarServiceFont;
import com.yootk.drp.vo.Shopcar;

import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping("/pages/front/center/shopcar/")
public class ShopcarActionFront extends AbstractAction {
    @Autowired
    private IShopCarServiceFont shopCarService;

    @RequestMapping("shopcar_delete")
    public void delete(String data){
        Set<Long> gids = new HashSet<>();
        String[] result = data.split(";");
        for (String gid :result){
            gids.add(Long.parseLong(gid));
        }
        try {
            super.print(this.shopCarService.deleteByMember(super.getFrontUser(),gids));
        } catch (Exception e) {
            super.print(false);
        }
    }
    @RequestMapping("shopcar_edit")
    public void edit(String data){
        String[] results = data.split(";");
        List<Shopcar> cars=new ArrayList<>();
        for (String result :results){
            String[] temp = result.split(":");
            Shopcar shopcar = new Shopcar();
            shopcar.setMid(super.getFrontUser());
            shopcar.setGid(Integer.parseInt(temp[0]));
            shopcar.setAmount(Integer.parseInt(temp[1]));
            cars.add(shopcar);
        }
        try {
            super.print(this.shopCarService.exitBatch(cars));
        } catch (Exception e) {
            super.print(false);
        }
    }


    @RequestMapping("shopcar_add")
    public void add(Shopcar vo){
        //如果用户未登录禁止后续操作
        if(super.getFrontUser()==null){
            super.print(false);
        }else{
            //保存当前用户名
            vo.setMid(super.getFrontUser());    //当前用户名
            try {
                super.print(this.shopCarService.add(vo));
            } catch (SQLException e) {
                super.print(false);
            }
        }
    }


    @Override
    public String getUploadDir() {
        return "/upload/shopcat";
    }
}
