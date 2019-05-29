package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.service.front.IAddressServiceFront;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Action;
import com.yootk.drp.vo.Address;

import java.sql.SQLException;

@Controller
@RequestMapping("/pages/front/center/address/")
public class AddressActionFront extends AbstractAction {

    @Autowired
    private IAddressServiceFront iAddressServiceFront;

    @RequestMapping("address_add_pre")
    public String addAddressPre(){
        return super.getPage("add.page");
    }

    @RequestMapping("address_add")
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
    @RequestMapping("address_list")
    public ModuleAndView findAll() throws Exception {
        ModuleAndView mav = new ModuleAndView("/pages/front/center/address/address_list.jsp");
        PageUtil pu = new PageUtil(super.getPage("list.action"));
        String mid = super.getFrontUser();
        try {
            mav.add(this.iAddressServiceFront.list(mid,pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("address_find")
    public ModuleAndView findAddr(Long adid) throws Exception {
        ModuleAndView mav = new ModuleAndView("/pages/front/center/address/address_find_pre.action");
        mav.add("address",this.iAddressServiceFront.findById(adid));
        return mav;
    }
    @RequestMapping("address_find_pre")
    public String findAddrPre(){

        return "/pages/front/center/address/address_edit.jsp";
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
