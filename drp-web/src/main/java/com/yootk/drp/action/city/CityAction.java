package com.yootk.drp.action.city;


import com.alibaba.fastjson.JSON;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.back.IWarehouseServiceFront;
import com.yootk.drp.service.back.IWitemServiceFront;
import com.yootk.drp.service.front.ICityServiceFront;
import com.yootk.drp.service.front.IProvinceServiceFront;

@Controller
public class CityAction extends AbstractAction {
    @Autowired
    private ICityServiceFront serviceFront;

    @RequestMapping("/city_list")
    public void list(Long pid) throws Exception {
        //查询所有的城市信息
        super.print(JSON.toJSONString(this.serviceFront.findAllById(pid)));
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
