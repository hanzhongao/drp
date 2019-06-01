package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.IGoodsServiceback;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Goods;

@Controller
@RequestMapping("/pages/back/admin/goods/")
public class GoodsBackAction extends AbstractAction {
    @Autowired
    private IGoodsServiceback goodsServiceback;

    @RequestMapping("goods_edit")
    public String edit(Goods goods, MultipartFile photo){
        try {
            if (photo != null) {
                String fileName = UploadFileToServer.upload(photo, photo.getContentType());
                goods.setPhoto(fileName);
                goods.setRecorder(super.getFrontUser());
            }else {
                goods.setPhoto(this.goodsServiceback.findPhotoById(goods.getGid()));
                goods.setRecorder(super.getFrontUser());
            }
            this.goodsServiceback.edit(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/pages/back/admin/goods/goods_list.action";
    }

    @RequestMapping("goods_edit_pre")
    public ModuleAndView editPre(Long gid){
        try {
            return new ModuleAndView("/pages/back/admin/goods/goods_edit.jsp", this.goodsServiceback.editPre(gid));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("goods_show")
    public ModuleAndView show(Long gid){
        try {
            return new ModuleAndView("/pages/back/admin/goods/goods_show.jsp", this.goodsServiceback.findMessage(gid));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("goods_add_pre")
    public ModuleAndView addAddressPre(){
        ModuleAndView mav = new ModuleAndView(super.getPage("add.page")) ;
        try {
            mav.add(goodsServiceback.addPre());
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("goods_add")
    public String addGoods(Goods goods,MultipartFile photo) throws Exception {
//        System.out.println(file+"*****************");
//        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
//            String fileName = UploadFileToServer.upload(file,file.getContentType()) ;
//            super.saveUploadFile(file);
//            goods.setPhoto(fileName);
//            String msg = super.getMessge("vo.add.failure","后台商品") ;
//            if (this.goodsServiceback.add(goods)) {
//                msg = super.getMessge("vo.add.success","后台商品") ;
//            }
//            String path = super.getPage("add.action") ;
//            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
//            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
//        return mav ;
        try {
            String fileName = UploadFileToServer.upload(photo,photo.getContentType());
            goods.setPhoto(fileName);
            goods.setRecorder(super.getFrontUser());
            this.goodsServiceback.add(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/goods/goods_list.action";
    }
    @RequestMapping("goods_list")
    public ModuleAndView findAll() throws Exception {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/goods/goods_list.jsp");
        PageUtil pu = new PageUtil(super.getPage("list.action"),"商品名称:name");
        String mid = super.getFrontUser();
        try {
            mav.add(this.goodsServiceback.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @Override
    public String getUploadDir() {

        return "/upload/member";  // 图片服务器的图片保存路径
    }
}
