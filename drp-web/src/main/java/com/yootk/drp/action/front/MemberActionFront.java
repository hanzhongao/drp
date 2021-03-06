package com.yootk.drp.action.front;

import com.alibaba.fastjson.JSON;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.servlet.web.CookieUtil;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.common.util.ResourceUtil;
import com.yootk.drp.service.front.IMemberServiceFront;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberActionFront extends AbstractAction {
    public static final String ACTION_TITLE = "用户";

    @Autowired
    private IMemberServiceFront memberServiceFront;

    @RequestMapping("/pages/plugins/back/modal/member_info")
    public void member_info_modal(String mid){
        try {
            super.print(JSON.toJSONString( this.memberServiceFront.findMemberInfo(mid)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/pages/front/center/member/member_message_edit")
    public ModuleAndView editMessage(String name,String phone,String email){
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        String mid = super.getFrontUser();
        String msg = super.getMessge("vo.add.failure","个人信息修改失败") ;
        try {
            if (this.memberServiceFront.editMessage(mid,name,phone,email)) {
                msg = super.getMessge("vo.add.success", "个人信息修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            String path = super.getPage("edit_message.action") ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        }
        return mav ;
    }
    @RequestMapping("/pages/front/center/member/member_message_edit_pre")
    public String editMessagePre(){
        return super.getPage("edit_message.page");
    }
    /**
     * 修用户改密码
     * @return
     */
    @RequestMapping("/pages/front/center/member/member_password_edit_pre")
    public String editPasswordPre(){
        return super.getPage("edit.page");
    }

    @RequestMapping("/pages/front/center/member/member_password_edit")
    public ModuleAndView editPassword(String oldpassword,String newpassword){
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        String mid = super.getFrontUser();
        String msg = super.getMessge("vo.add.failure","修改密码失败") ;
        try {
            if (this.memberServiceFront.findPassWord(mid,oldpassword)) {
                if(this.memberServiceFront.editPassword(mid,newpassword)) {
                    msg = super.getMessge("vo.add.success", "修改密码成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            String path = super.getPage("edit.action") ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        }
        return mav ;
    }
    /**
     * 注册
     * @return
     */
    @RequestMapping("/regist_pre")
    public String registPre(){
        return super.getPage("regist.page");
    }
    /**
     * 注册
     * @param member
     * @return
     */
    @RequestMapping("/regist")
    public ModuleAndView regist(Member member){
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        try {
            String msg = super.getMessge("vo.add.failure","账号注册失败") ;

            if (this.memberServiceFront.addMember(member)) {
                msg = super.getMessge("vo.add.success","账号注册成功") ;
            }
            String path = super.getPage("regist.action") ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }


    /**
     * 用户登录注销，登录注销后所有的Cookie信息将被删除
     *
     * @return 提示页面，随后跳转回登录页
     */
    @RequestMapping("/member_logout")
    public ModuleAndView logout() {
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        String mid = super.getFrontUser();
        CookieUtil.clean(ServletObject.getResponse(), "info");
        ServletObject.getRequest().getSession().invalidate();
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        if (mid != null) {
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("logout.success", ACTION_TITLE));
        } else {
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("logout.already", ACTION_TITLE));
        }
        return mav;
    }

    /**
     * 验证码检测，用于ajax异步验证处理
     *
     * @param code 输入验证码
     */
    @RequestMapping("/code_check")
    public void check(String code) {
        String rand = (String) ServletObject.getRequest().getSession().getAttribute("rand");
        if (rand == null || "".equals(rand)) {
            super.print(false);
        } else {
            super.print(rand.equalsIgnoreCase(code));
        }
    }
    /**
     * 登录前的页面跳转处理
     *
     * @return 返回到登录页
     */
    @RequestMapping("/member_login_pre")
    public ModuleAndView loginPre() {
        ModuleAndView mav = new ModuleAndView(super.getPage("login.page"));
        return mav;
    }
    /**
     * 用户登录处理
     *
     * @param vo         包含有用户登录信息
     * @param rememberme 是否要执行免登录
     * @return 登录成功返回信息提示页（随后跳转到商品列表页），登录失败返回登录页
     */
    @RequestMapping("/member_login")
    public ModuleAndView login(Member vo, String rememberme) throws Exception {
        ModuleAndView mav = new ModuleAndView(super.getPage("login.action"));
        vo.setPassword(EncryptUtil.encode(vo.getPassword()));
        if (memberServiceFront.login(vo)) {
            ServletObject.getRequest().getSession().setAttribute("mid", vo.getMid());
            Integer type = memberServiceFront.findTypeByMid(vo.getMid());
            ServletObject.getRequest().getSession().setAttribute("type", type);
            mav.setView(super.getForwardPage());
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.success", ACTION_TITLE));
            if (rememberme != null && "true".equals(rememberme)) {
                // 将用户信息保存在Cookie之中，方便用户下一次免登录操作
                CookieUtil.set("info", vo.getMid() + ":" + vo.getPassword(), ServletObject.getResponse());
            }
        } else {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("login.page"));
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.failure", ACTION_TITLE));
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/member";
    }
}
