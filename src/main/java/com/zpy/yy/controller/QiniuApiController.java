package com.zpy.yy.controller;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.Doctor;
import com.zpy.yy.bean.Sufferer;
import com.zpy.yy.service.IAppTokenService;
import com.zpy.yy.service.IDoctorService;
import com.zpy.yy.service.ISuffererService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 俊毅 on 2015/12/16.
 */
@Controller
@RequestMapping("/qiniuApi")
public class QiniuApiController extends BaseController {

    @Autowired
    Auth qiniuAuth;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    ISuffererService iSuffererService;

    @Autowired
    IDoctorService iDoctorService;

    @RequestMapping("/prepareForUploadImage")
    @ResponseBody
    public AjaxModel prepareForUploadImage() {
        AjaxModel model = new AjaxModel();
        StringMap stringMap = new StringMap();
        String resourceKey = "photoImage/" + System.currentTimeMillis();
        stringMap.put("statusCode", "200");
        stringMap.put("message", "可以上传");
        String uploadToken = qiniuAuth.uploadToken("zpy2015", resourceKey, 36000, stringMap);//第一个参数是存储空间名称
        Map map = new HashMap();
        map.put("token", uploadToken);
        map.put("key", resourceKey);
        model.setData(map);
        model.setCode(AjaxCode.OK);
        return model;
    }

    @RequestMapping("/afterUploadImage")
    @ResponseBody
    public AjaxModel afterUploadImage(String token, String photoUrlQiniu) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token)) {
            model.setCode(AjaxCode.TOKEN_IS_NULL);
            return model;
        }
        if (TextUtil.isEmpty(photoUrlQiniu)) {
            model.setCode(AjaxCode.PARAM_ERROR);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.ACCOUNT_IS_REPLACED);
            return model;
        }
        Integer userId = appToken.getUserId();
        Sufferer sufferer = iSuffererService.findSufferById(userId);
        if (sufferer != null) {
            sufferer.setPhoto(photoUrlQiniu);
            if(iSuffererService.updateSuffer(sufferer)){
                model.setCode(AjaxCode.OK);
                return model;
            }
        } else {
            Doctor doctor = iDoctorService.findDoctorById(userId);
            if (doctor == null) {
                model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
                return model;
            }
            doctor.setPhoto(photoUrlQiniu);
            if(iDoctorService.updateDoctor(doctor)) {
                model.setCode(AjaxCode.OK);
                return model;
            }
        }
        return model;
    }
}
