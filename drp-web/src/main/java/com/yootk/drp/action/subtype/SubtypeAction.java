package com.yootk.drp.action.subtype;

import com.alibaba.fastjson.JSON;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;

import com.yootk.drp.service.back.ISubtypeServiceback;

@Controller

public class SubtypeAction extends AbstractAction {
    @Autowired
    private ISubtypeServiceback subtypeServiceFront;

    @RequestMapping("/subtype_list")
    public void list(Long wiid) throws Exception {
        super.print(JSON.toJSONString(this.subtypeServiceFront.findAllById(wiid)));
    }
    @Override
    public String getUploadDir() {

        return null;
    }
}
