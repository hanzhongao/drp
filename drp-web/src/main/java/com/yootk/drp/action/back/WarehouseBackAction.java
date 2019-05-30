package com.yootk.drp.action.back;


import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.IWarehouseServiceFront;
import com.yootk.drp.service.back.IWitemServiceFront;
import com.yootk.drp.service.front.IProvinceServiceFront;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

@Controller
@RequestMapping("/pages/back/admin/warehouse/")
public class WarehouseBackAction extends AbstractAction {
    @Autowired
    private IWarehouseServiceFront warehService;
    @Autowired
    private IWitemServiceFront witemService;
    @Autowired
    private IProvinceServiceFront provinceServiceFront;

    @RequestMapping("warehouse_list")
    public ModuleAndView list(){
        ModuleAndView mav = new ModuleAndView(super.getPage("list.page"));
        try {
            //查询仓库用途
            mav.add("findAll",this.witemService.findAll());
            //调用城市一级级联菜单
            mav.add("findpro",this.provinceServiceFront.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("warehouse_add")
    public ModuleAndView add(Warehouse warehouse, MultipartFile pic) throws Exception {
        String fileName = null;
        if(pic ==null ||"".equals(pic)){
            fileName = "nophoto.jpg";
        }else{
            fileName = UploadFileToServer.upload(pic,pic.getContentType()) ;
        }
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        warehouse.setPhoto(fileName);
        warehouse.setRecorder(super.getFrontUser());
        warehouse.setAdmin(super.getFrontUser());
        if( this.warehService.doCreate(warehouse)){
            //回到当前的增加的页面
            String path = super.getPage("houseList.action") ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "数据信息增加成功");
        }else{
            //不成功
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("houseAdd.page"));
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "对不起，数据信息增加失败");
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("house_list")
    public ModuleAndView houseList() throws SQLException {
        ModuleAndView mav = new ModuleAndView(super.getPage("houseList.page"));
        Warehouse wiid = this.warehService.findByWiid();
        PageUtil pu = new PageUtil(super.getPage("add.action"),"仓库名称:name|管理员姓名:recorder");
        try {
//            //查询全部商品仓库信息
//            mav.add("houseList", this.warehService.findAll());
            //查询全部商品仓库属性
            mav.add("houseTitle",this.witemService.findByTile(wiid.getWiid()));
            //分页查询和分页
            System.out.println();
            mav.add(this.warehService.findSearchOrSplit(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("house_editPre")
    public ModuleAndView houseEdit(Long wid) throws SQLException {
        System.out.println(wid);
        ModuleAndView mav = new ModuleAndView(super.getPage("houseEdit.page"));
        if(wid ==null ||"".equals(wid)){
            return null;
        }
        try {
            Warehouse byWid = this.warehService.findByWid(wid);
            //根据修改的仓库id查询所有的仓库信息
            mav.add("editPre",byWid);
            //查询所有放库信息中的城市信息
            mav.add("findpro",this.provinceServiceFront.findAll());
            //查询所有的仓库属性信息
            mav.add("findAll",this.witemService.findAll());
            mav.add("findByCid",this.warehService.findByCid(byWid.getCid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("warehouse_edit")
    public ModuleAndView
    doEdit(Warehouse warehouse,MultipartFile pic) throws Exception {
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        String fileName = null;
        if(pic ==null ||"".equals(pic)){
            fileName = "nophoto.jpg";
        }else{
            fileName = UploadFileToServer.upload(pic,pic.getContentType()) ;
        }
        warehouse.setPhoto(fileName);
        if(this.warehService.doEdit(warehouse)){//成功
            String path = super.getPage("houseEdit.page") ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            warehouse.setRecorder(super.getFrontUser());
            warehouse.setAdmin(super.getFrontUser());
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "数据修改成功");
        }else{
            //不成功
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("houseEdit.page"));
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "对不起，数据信息修改失败");
        }
        return mav;
    }


    @Override
    public String getUploadDir() {
        return "/upload/warehouse";
    }
}
