package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.dao.impl.MemberDAOImpl;
import com.yootk.drp.service.back.IMemberServiceBack;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Member;

import java.util.Date;


@Controller // 控制层注解
@RequestMapping("/pages/back/admin/emp/") // 定义的是访问路径，这个路径不允许为空，如果为空，该方法无法与路径映射

/**
 *  雇员添加的控制层
 */
public class MemberActionBack extends AbstractAction {

    @Autowired
    private IMemberServiceBack memberServiceBack;  // 注入业务层对象


    @Override
    public String getUploadDir() {
        return "/upload/member";  // 图片服务器的图片保存路径
    }

    /**
     *  添加雇员信息前的查询操作，主要是为了向页面中的 所属部门 和 职位类型 两个下拉列表准备数据
     *  @return 返回包含跳转页面和 map数据的 ModuleAndView 对象
     */
    @RequestMapping("emp_add_pre") // 定义的是访问路径，不允许为空
    public ModuleAndView addPre() {

        // add.page为要跳转的路径,完整路径保存在 配置文件 Page.properties中
        ModuleAndView mav = new ModuleAndView(super.getPage("add.page"));
        try {
            // 下面一行代码将调用业务层，取得一组map数据
            // 1、key = allDepts、 value = 部门List集合
            // 2、key = allLevels、value = 职位List集合
            mav.add(memberServiceBack.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav; // 返回包含跳转页面的map数据的 ModuleAndView 对象
    }

    /**
     * 添加雇员信息
     * @param vo 雇员信息 vo
     * @param pic 要保存的图片
     */
    @RequestMapping("emp_add") // 定义的是访问路径，不允许为空
    public ModuleAndView add(Member vo, MultipartFile pic){
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ; // 添加成功后跳转到倒计时页面
        try {
            String fileName = UploadFileToServer.upload(pic,pic.getContentType()) ; // 要上传的图片
            vo.setPhoto(fileName); // 向vo中保存图片
            vo.setRegdate(new Date()); // 设置雇佣日期
            vo.setPassword(EncryptUtil.encode(vo.getPassword())); // 密码加密
            String path = super.getPage("list.action"); // 雇员添加页面
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,path); // 跳转回 雇员增加页面
            this.memberServiceBack.add(vo); // 调用业务层 方法，添加雇员信息
        } catch (Exception e) {
            e.printStackTrace();
            super.print(false);
        }
        return mav ;
    }

    /**
     * 雇员列表分页显示功能控制层
     * @return ModuleAndView
     * @author hanzhongao
     */
    @RequestMapping("emp_list")
    public ModuleAndView list(){
        ModuleAndView mav = new ModuleAndView(super.getPage("list.page")); // 跳转路径
        PageUtil pu = new PageUtil(super.getPage("list.action")); // 分页组件
        try {
            mav.add(this.memberServiceBack.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     * 修改雇员信息前的查询操作，为表单准备回填数据
     * @author hanzhongao
     */
    @RequestMapping("emp_edit_pre")
    public ModuleAndView editPre(String mid) {
        // 显示层路径为：/pages/back/admin/emp/emp_edit.jsp
        ModuleAndView mav = new ModuleAndView(super.getPage("edit.page")) ;
        try {
            // 1、key = allDepts、 value = 部门List集合；
            // 2、key = allLevels、value = 职位List集合；
            // 3、key = members、value = 要改的雇员信息。
            mav.add(memberServiceBack.preEdit(mid));  // 存放回填用的数据
        } catch (Exception e) {
            e.printStackTrace();
            return null ;

        }
        return mav ;
    }

    /**
     * 雇员信息修改
     * @author hanzhongao
     */
    @RequestMapping("emp_edit")
    public ModuleAndView edit(Member vo, MultipartFile photo) {
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ; // 添加成功后跳转到倒计时页面
        try {
            if (photo != null) {
                String fileName = UploadFileToServer.upload(photo,photo.getContentType()) ; // 要上传的图片
                vo.setPhoto(fileName); // 向vo中保存图片
            } else {
                Member member = (Member) this.memberServiceBack.preEdit(vo.getMid()).get("member");
                vo.setPhoto(member.getPhoto()); // 如果没有上传图片，则使用原来的图片
            }
            vo.setPassword(EncryptUtil.encode(vo.getPassword())); // 密码加密
            String path = "/pages/back/admin/emp/emp_list.action"; // 修改后跳回此页面
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,path); // 跳转回 /pages/back/admin/emp/emp_list.action
            this.memberServiceBack.edit(vo); // 调用业务层 方法，编辑雇员信息
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        }
        return mav ;
    }
}
