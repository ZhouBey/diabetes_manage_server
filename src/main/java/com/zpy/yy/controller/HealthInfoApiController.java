package com.zpy.yy.controller;

import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.service.IHealthInfoService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import com.zpy.yy.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/healthInfoApi")
public class HealthInfoApiController {
    @Autowired
    IHealthInfoService iHealthInfoService;

    /**
     * 添加健康咨询
     *
     * @param title
     * @param msg
     * @param image_info
     * @return
     */
    @RequestMapping("/addHealthInfo")
    @ResponseBody
    public AjaxModel addHealthInfo(String title, String msg, String image_info) {
        AjaxModel model = new AjaxModel();
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setTitle(title);
        healthInfo.setInfoImage(image_info);
        healthInfo.setMsg(msg);
        if (iHealthInfoService.addHealthInfo(healthInfo)) {
            model.setCode(AjaxCode.OK);
        } else {
            model.setCode(AjaxCode.ERROR);
        }
        return model;
    }

    /**
     * 获取健康咨询
     *
     * @param pageInfo
     * @return
     */
    @RequestMapping("/getHealthInfoList")
    @ResponseBody
    public AjaxModel getHealthInfoList(PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        List<HealthInfo> healthInfos = iHealthInfoService.searchHealthInfoListPage(pageInfo);
        model.setCode(AjaxCode.OK);
        Map map = new HashMap();
        map.put("healthInfos", healthInfos);
        map.put("pageInfo", pageInfo);
        model.setData(map);
        return model;
    }

    /**
     * 今日推荐
     */
    @RequestMapping("/getTodayPushHealth")
    @ResponseBody
    public AjaxModel getTodayPushHealth() {
        AjaxModel model = new AjaxModel();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(1);
        pageInfo.setShowCount(3);
        List<HealthInfo> healthInfos = iHealthInfoService.searchHealthInfoListPage(pageInfo);
        model.setCode(AjaxCode.OK);
        Map map = new HashMap();
        map.put("todayPushHealth", healthInfos);  
        model.setData(map);
        return model;
    }
}
