package com.yootk.drp.action.back;


import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.INewsServiceback;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.News;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class NewsBackAction extends AbstractAction {
    @Autowired
    private INewsServiceback newsServiceback;

    @RequestMapping("/pages/back/admin/news/news_remove")
    public void removeNews(String data){
        Set<Long> nids = new HashSet<>();
        String result[] = data.split(";");
        for (String nid : result){
            nids.add((long) Integer.parseInt(nid));
        }
        try {
            super.print(this.newsServiceback.doRemove(nids));
        } catch (SQLException e) {
            super.print(false);
        }
    }

    @RequestMapping("/pages/back/admin/news/news_updataStatus")
    public void updateStatus(String data){
        Set<Integer> nids = new HashSet<>();
        String result[] = data.split(";");
        for (String nid : result){
            nids.add(Integer.parseInt(nid));
        }
        try {
            super.print(this.newsServiceback.updateStatusById(super.getFrontUser(),nids));
        } catch (SQLException e) {
            super.print(false);
        }
    }
    @RequestMapping("/pages/back/admin/news/news_flush")
    public void findStatusById(String data){
        Set<Integer> nids = new HashSet<>();
        String result[] = data.split(";");
        for (String nid : result){
            nids.add(Integer.parseInt(nid));
        }
        try {
            super.print(this.newsServiceback.findStatusById(nids));
        } catch (SQLException e) {
            super.print(3);
        }
    }

    @RequestMapping("/pages/back/admin/news/news_add")
    public String addNews(News news, MultipartFile photo){
        try {
            String fileName = UploadFileToServer.upload(photo,photo.getContentType());
            news.setPhoto(fileName);
            this.newsServiceback.addNews(news);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/news/news_list.action";
    }
    @RequestMapping("/pages/back/admin/news/news_list")
    public ModuleAndView listNews(){
        PageUtil pu = new PageUtil("/pages/back/admin/news/news_list.action","公告标题:title|公告发布者:gid");
        try {
            ModuleAndView mav = new ModuleAndView("/pages/back/admin/news/news_list.jsp",this.newsServiceback.findAllNews(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
            return mav;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/pages/back/admin/news/news_edit_pre")
    public ModuleAndView editPre(Long nid){
        try {
            return new ModuleAndView("/pages/back/admin/news/news_edit.jsp", this.newsServiceback.editPre(nid));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/pages/back/admin/news/news_edit")
    public String edit(News news,MultipartFile photo){
        System.out.println(news);
        try {
            if (photo != null) {
                String fileName = UploadFileToServer.upload(photo, photo.getContentType());
                news.setPhoto(fileName);
            }else {
                news.setPhoto(this.newsServiceback.findPhotoById(news.getNid()));
            }
            news.setIssuer(super.getFrontUser());
            this.newsServiceback.edit(news);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/pages/back/admin/news/news_list.action";
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
