package com.zpy.yy.controller;

import com.zpy.yy.base.BaseConfig;
import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.*;
import com.zpy.yy.service.*;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import com.zpy.yy.util.PageInfo;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/suffererApi")
public class SuffererApiController extends BaseController {

    @Autowired
    ISuffererService iSuffererService;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    IBloodSugarLogService iBloodSugarLogService;

    @Autowired
    IQuestionService iQuestionService;

    @Autowired
    IQuestionAndAnswerService iQuestionAndAnswerService;

    /**
     * 患者注册
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/suffererRegister")
    @ResponseBody
    public AjaxModel suffererRegister(String phone, String password) {
        System.out.println("phone=" + phone);
        System.out.println("password=" + password);
        AjaxModel model = new AjaxModel();
        if (iSuffererService.phoneExist(phone)) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_EXIST);
            return model;
        }
        Sufferer sufferer = new Sufferer();
        sufferer.setPhone(phone);
        sufferer.setPassword(password);
        if (iSuffererService.addSuffer(sufferer)) {
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }

    /**
     * 患者登录
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/suffererLogin")
    @ResponseBody
    public AjaxModel suffererLogin(String phone, String password) {
        System.out.println("phone=" + phone);
        System.out.println("password=" + password);
        AjaxModel model = new AjaxModel();
        if (!iSuffererService.phoneExist(phone)) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        Sufferer sufferer = iSuffererService.getSuffererByPassword(phone, password);
        if (sufferer == null) {
            model.setCode(AjaxCode.LOGIN_ERROR);
            return model;
        }
        Map map = new HashMap();
        System.out.println("sufferer.getId()=" + sufferer.getId());
        AppToken appToken = iAppTokenService.findAppTokenByUserId(sufferer.getId(), BaseConfig.ROLE_TYPE_FOR_SUFFERER);
        System.out.println(appToken);
        map.put("appToken", appToken);
        model.setData(map);
        model.setCode(AjaxCode.OK);
        return model;
    }

    /**
     * 获取患者信息
     *
     * @param token
     * @return
     */
    @RequestMapping("/getSuffererInfo")
    @ResponseBody
    public AjaxModel getSuffererInfo(String token) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token)) {
            model.setCode(AjaxCode.TOKEN_IS_NULL);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.ACCOUNT_IS_REPLACED);
            return model;
        }
        Integer userId = appToken.getUserId();
        Sufferer sufferer = iSuffererService.findSufferById(userId);
        Map map = new HashMap();
        map.put("sufferer", sufferer);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }

    @RequestMapping("/uploadMyPhoto")
    @ResponseBody
    public AjaxModel uploadMyPhoto(String token, String photo) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token)) {
            model.setCode(AjaxCode.TOKEN_IS_NULL);
            return model;
        }
        if (TextUtil.isEmpty(photo)) {
            model.setCode(AjaxCode.PHOTO_IS_NULL);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        Integer userId = appToken.getUserId();
        Sufferer sufferer = iSuffererService.findSufferById(userId);
        if (sufferer == null) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        sufferer.setPhoto(photo);
        iSuffererService.updateSuffer(sufferer);
        model.setCode(AjaxCode.OK);
        return model;
    }

    /**
     * 更新患者资料
     *
     * @param name
     * @param sex
     * @param birthday
     * @param sufferDate
     * @return
     */
    @RequestMapping("/updateSuffererInfo")
    @ResponseBody
    public AjaxModel updateSuffererInfo(String token, String name, String sex, String birthday, String sufferDate) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token)) {
            model.setCode(AjaxCode.TOKEN_IS_NULL);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.ACCOUNT_IS_REPLACED);
            return model;
        }
        Integer userId = appToken.getUserId();
        Sufferer sufferer = iSuffererService.findSufferById(userId);
        if (sufferer == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        if (!TextUtil.isEmpty(name)) {
            sufferer.setName(name);
        }
        if (!TextUtil.isEmpty(sex)) {
            if ("男".equals(sex)) {
                sufferer.setSex(0);
            } else {
                sufferer.setSex(1);
            }

        }
        if (!TextUtil.isEmpty(birthday)) {
            Date date = TextUtil.str2Date(birthday);
            sufferer.setBirthday(date);
        }
        if (!TextUtil.isEmpty(sufferDate)) {
            Date date = TextUtil.str2Date(sufferDate);
            sufferer.setSufferedDate(date);
        }
        iSuffererService.updateSuffer(sufferer);
        model.setCode(AjaxCode.OK);
        return model;

    }

    /**
     * 患者添加当天的血糖记录
     *
     * @param token
     * @param sugar_content
     * @return
     */
    @RequestMapping("/addBloodSugarLog")
    @ResponseBody
    public AjaxModel addBloodSugarLog(String token, String sugar_content) {
        AjaxModel model = new AjaxModel();
        //通过token查找用户
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        Integer user_id = appToken.getUserId();
        Sufferer sufferer = iSuffererService.findSufferById(user_id);
        if (sufferer == null) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        //判断今天是否已经添加血糖记录
        BloodSugarLog bloodSugarLog = iBloodSugarLogService.findBloodSugarLogByDateAndSuffererId(new Date(), user_id);
        if (bloodSugarLog != null) {
            model.setCode(AjaxCode.CURRENT_BLOOD_SUGAR_LOG_EXIST);
            return model;
        }
        //开始添加
        bloodSugarLog = new BloodSugarLog();
        bloodSugarLog.setSuffererId(user_id);
        Double sugar_content_d = Double.parseDouble(sugar_content);
        bloodSugarLog.setSugarContent(sugar_content_d);
        if (iBloodSugarLogService.addBloodSugarLog(bloodSugarLog)) {
            bloodSugarLog = iBloodSugarLogService.findBloodSugarLogById(11);
            System.out.print(bloodSugarLog);
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }

    /**
     * 患者获取本周的血糖记录
     *
     * @return
     */
//    @RequestMapping("/getCurrentWeekBloodSugarLog")
//    @ResponseBody
//    public AjaxModel getCurrentWeekBloodSugarLog(String token) {
//        AjaxModel model = new AjaxModel();
//
//        //通过token查找用户
//        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
//        if (appToken == null) {
//            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
//            return model;
//        }
//        Integer user_id = appToken.getUserId();
//
//        List<BloodSugarLog> bloodSugarLogs = new ArrayList<>();
//        int weekOfDate = TextUtil.getWeekOfDate(new Date()) + 1;
//        Date date = new Date();
//        while (--weekOfDate > 0) {
//            BloodSugarLog bloodSugarLog = iBloodSugarLogService.findBloodSugarLogByDateAndSuffererId(date, user_id);
//            if (bloodSugarLog != null) {
//                bloodSugarLogs.add(bloodSugarLog);
//            }
//            date = TextUtil.getPrevDate(date);
//        }
//        if (bloodSugarLogs.size() == 0) {
//            model.setCode(AjaxCode.CURRENT_WEEK_NO_BLOOD_SUGAR_LOG);
//            return model;
//        }
//        Map map = new HashMap();
//        map.put("bloodSugarLogs", bloodSugarLogs);
//        model.setCode(AjaxCode.OK);
//        model.setData(map);
//        return model;
//    }

    /**
     * 获取患者列表
     *
     * @param pageInfo
     * @return
     */
    @RequestMapping("/getSuffererListPage")
    @ResponseBody
    public AjaxModel getSuffererListPage(PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        List<Sufferer> sufferers = iSuffererService.getAllHealthInfoListPage(pageInfo);
        Map map = new HashMap();
        map.put("sufferers", sufferers);
        map.put("pageInfo", pageInfo);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }
}
