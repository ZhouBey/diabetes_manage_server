package com.zpy.yy.controller;

import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.BloodSugarLog;
import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.service.IAppTokenService;
import com.zpy.yy.service.IBloodSugarLogService;
import com.zpy.yy.service.IHealthInfoService;
import com.zpy.yy.service.ISuffererService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import com.zpy.yy.util.PageInfo;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by 俊毅 on 2015/12/12.
 */
@Controller
@RequestMapping("/indexApi")
public class IndexApiController extends BaseController {

    @Autowired
    IHealthInfoService iHealthInfoService;

    @Autowired
    IBloodSugarLogService iBloodSugarLogService;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    ISuffererService iSuffererService;

    @RequestMapping("/getIndexInfo")
    @ResponseBody
    public AjaxModel getIndexInfo(String token) {
        AjaxModel model = new AjaxModel();
        Map map = new HashMap();
        if (!TextUtil.isEmpty(token)) {
            AppToken appToken = iAppTokenService.findAppTokenByToken(token);
            if (appToken != null) {
                Integer userId = appToken.getUserId();
                if (userId != null) {
                    BloodSugarLog sugarLogToday = iBloodSugarLogService.findBloodSugarLogByDateAndSuffererId(new Date(), userId);
                    if (sugarLogToday != null) {
                        map.put("sugarLog", sugarLogToday);
                    }

                    List<BloodSugarLog> bloodSugarLogs = new ArrayList<>();
                    int weekOfDate = TextUtil.getWeekOfDate(new Date()) + 1;
                    Date date = new Date();
                    while (--weekOfDate > 0) {
                        BloodSugarLog bloodSugarLog = iBloodSugarLogService.findBloodSugarLogByDateAndSuffererId(date, userId);
                        if (bloodSugarLog != null) {
                            bloodSugarLogs.add(bloodSugarLog);
                        }
                        date = TextUtil.getPrevDate(date);
                    }
                    map.put("weekOfBloodSugarLogs", bloodSugarLogs);
                }
            }
        }
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(1);
        pageInfo.setShowCount(8);
        List<HealthInfo> healthInfos = iHealthInfoService.searchHealthInfoListPage(pageInfo);
        map.put("healthInfos", healthInfos);
        map.put("pageInfo", pageInfo);
        model.setData(map);
        model.setCode(AjaxCode.OK);
        return model;
    }
}
