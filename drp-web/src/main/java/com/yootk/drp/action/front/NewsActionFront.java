package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.INewsServiceback;
import com.yootk.drp.service.front.INewServiceFront;

import java.sql.SQLException;

@Controller
public class NewsActionFront extends AbstractAction {

    @Autowired
    private INewServiceFront newServiceFront;

    @RequestMapping("/pages/front/news/news_list_back")
    public ModuleAndView listBackNews(){
        PageUtil pu = new PageUtil("/pages/front/news/news_list_back.action");
        try {
            ModuleAndView mav = new ModuleAndView("/pages/front/news/news_list.jsp",this.newServiceFront.findAllNews(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
            return mav;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/pages/front/news/news_show")
    public ModuleAndView findNewByID(Long nid){
        try {
            return new ModuleAndView("/pages/front/news/news_show.jsp", this.newServiceFront.findNewById(nid));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/pages/front/news/news_list_front")
    public ModuleAndView listFrontNews(){
        PageUtil pu = new PageUtil("/pages/front/news/news_list_front.action");
        try {
            ModuleAndView mav = new ModuleAndView("/index.jsp",this.newServiceFront.findAllNews(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
            return mav;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/pages/front/news/news_list")
    public ModuleAndView listListNews(){
        PageUtil pu = new PageUtil("/pages/front/news/news_list_front.action");
        try {
            ModuleAndView mav = new ModuleAndView("/index.jsp",this.newServiceFront.findAllNews(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
            return mav;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
