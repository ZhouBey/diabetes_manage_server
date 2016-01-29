package com.zpy.yy.controller;

import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.Doctor;
import com.zpy.yy.bean.Opinion;
import com.zpy.yy.bean.Sufferer;
import com.zpy.yy.service.IAppTokenService;
import com.zpy.yy.service.IDoctorService;
import com.zpy.yy.service.IOpinionService;
import com.zpy.yy.service.ISuffererService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2015/12/2 0002.
 */
@Controller
@RequestMapping("/opinionApi")
public class OpinionApiController extends BaseController {

    @Autowired
    IOpinionService iOpinionService;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    ISuffererService iSuffererService;

    @Autowired
    IDoctorService iDoctorService;

    @RequestMapping("/addOpinion")
    @ResponseBody
    public AjaxModel addOpinion(String token, String content) {
        AjaxModel model = new AjaxModel();
        if (content == null) {
            model.setCode(AjaxCode.PARAM_ERROR);
            return model;
        }
        if ("".equals(content)) {
            model.setCode(AjaxCode.ERROR);
            return model;
        }
        Opinion opinion = new Opinion();
        opinion.setContent(content);
        if (!TextUtil.isEmpty(token)) {
            AppToken appToken = iAppTokenService.findAppTokenByToken(token);
            if (appToken != null) {
                Integer roleType = appToken.getRoleType();
                if(roleType==0) {
                    Sufferer sufferer = iSuffererService.findSufferById(appToken.getUserId());
                    opinion.setPhone(sufferer.getPhone());
                }else {
                    Doctor doctor = iDoctorService.findDoctorById(appToken.getId());
                    opinion.setPhone(doctor.getPhone());
                }
            }
        }
        if (iOpinionService.addOpinion(opinion)) {
            model.setCode(AjaxCode.OK);
        } else {
            model.setCode(AjaxCode.ERROR);
        }
        return model;

    }

}
