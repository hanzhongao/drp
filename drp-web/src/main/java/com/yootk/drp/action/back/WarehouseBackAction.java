package com.yootk.drp.action.back;


import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.back.IWarehouseServiceFront;
import com.yootk.drp.service.back.IWitemServiceFront;
import com.yootk.drp.service.front.IProvinceServiceFront;

@Controller
@RequestMapping("/pages/back/admin/warehouse/")
public class WarehouseBackAction extends AbstractAction {
    @Autowired
    private IWarehouseServiceFront warehService;
    @Autowired
    private IWitemServiceFront witemService;
    @Autowired
    private IProvinceServiceFront provinceServiceFront;

    @RequestMapping("warehouse_add")
    public ModuleAndView list(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/warehouse/warehouse_add.jsp");
        try {
            mav.add("findAll",this.witemService.findAll());
            mav.add("findpro",this.provinceServiceFront.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @Override
    public String getUploadDir() {
        return "/upload/warehouse";
    }
}
