package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.front.IAddressServiceFront;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Address;

@Controller
@RequestMapping("/pages/front/center/address")
public class AddressActionFront extends AbstractAction {

    @Autowired
    private IAddressServiceFront iAddressServiceFront;

    @RequestMapping("/address_add_pre")
    public String addAddressPre(){
        return super.getPage("add.page");
    }

    @RequestMapping("/address_add")
    public ModuleAndView addAddress(Address address){
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        String mid = super.getFrontUser();
        address.setMid(mid);
        try {
            String msg = super.getMessge("vo.add.failure","地址") ;

            if (this.iAddressServiceFront.add(address)) {
                msg = super.getMessge("vo.add.success","地址") ;
            }
            String path = super.getPage("add.action") ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
