package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.dao.ICityDAO;
import com.yootk.drp.dao.IProvinceDAO;
import com.yootk.drp.service.front.IAddressServiceFront;
import com.yootk.drp.service.front.ICityServiceFront;
import com.yootk.drp.service.front.IProvinceServiceFront;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Action;
import com.yootk.drp.vo.Address;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/pages/front/center/address/")
public class AddressActionFront extends AbstractAction {
    @Autowired
    private IProvinceServiceFront provinceServiceFront;
    @Autowired
    private ICityServiceFront cityServiceFront;
    @Autowired
    private IAddressServiceFront iAddressServiceFront;


    @RequestMapping("address_delete")
    public void delete(String data){
        Set<Integer> adids = new HashSet<>();
        String result[] = data.split(";");
        for (String adid : result){
            adids.add(Integer.parseInt(adid));
        }
        try{
            super.print(this.iAddressServiceFront.deleteByAdid(super.getFrontUser(),adids));
        }catch (Exception e){
            super.print(false);
        }
    }
    @RequestMapping("address_add_pre")
    public ModuleAndView addAddressPre(){
        ModuleAndView mav = new ModuleAndView(super.getPage("add.page")) ;
        try {
            mav.add(iAddressServiceFront.addPre());
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav ;
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
    @RequestMapping("address_edit")
    public ModuleAndView edit(Address address) throws Exception {
        ModuleAndView mav = new ModuleAndView(super.getPage("edit.action"));
        try{
            this.iAddressServiceFront.edit(address);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("address_edit_pre")
    public ModuleAndView editPre(Long adid){
        try {
            return new ModuleAndView(super.getPage("edit.page"), this.iAddressServiceFront.editPre(adid));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
