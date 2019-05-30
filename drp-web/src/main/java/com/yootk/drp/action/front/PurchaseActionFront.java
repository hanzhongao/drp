package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.util.ResourceUtil;
import com.yootk.drp.service.front.IPurchaseServiceFront;

import static com.yootk.drp.action.front.MemberActionFront.ACTION_TITLE;

/**
 * @author yaoxinlan
 */
@Controller
@RequestMapping("/pages/front/center/purchase/")
public class PurchaseActionFront extends AbstractAction {
    @Autowired
    private IPurchaseServiceFront purchaseServiceFront;

    @RequestMapping("certified")
    public ModuleAndView isAuthencationAndForward() {
        String mid = super.getFrontUser();
        ModuleAndView mav = null;
        try {
            if (purchaseServiceFront.isAuthencation(mid)) {
                mav = new ModuleAndView(super.getForwardPage());
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("authencation.already", ACTION_TITLE));
            } else {

            }
        } catch (Exception e) {
        }
        return mav;
    }

    @RequestMapping("auth")
    public ModuleAndView isAuthencation() {
        String mid = super.getFrontUser();
        ModuleAndView mav = new ModuleAndView();
        try {
            if (purchaseServiceFront.isAuthencation(mid)) {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "true");
                super.print("true");
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "false");
                super.print("false");
            }
        } catch (Exception e) {
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
