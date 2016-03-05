package com.zpy.yy.controller;

import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.DoctorPatient;
import com.zpy.yy.service.IAppTokenService;
import com.zpy.yy.service.IDoctorPatientService;
import com.zpy.yy.service.ISuffererService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import com.zpy.yy.util.PageInfo;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
@Controller
@RequestMapping("/doctorPatientApi")
public class DoctorPatientApiController extends BaseController {

    @Autowired
    IDoctorPatientService iDoctorPatientService;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    ISuffererService iSuffererService;

    /**
     * 患者添加关注医生
     *
     * @param token
     * @param doctorId
     * @return
     */
    @RequestMapping("/addDoctorPatient")
    @ResponseBody
    public AjaxModel addDoctorPatient(String token, Integer doctorId) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token) || doctorId == null) {
            model.setCode(AjaxCode.PARAM_ERROR);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        Integer suffererId = appToken.getUserId();
        if (suffererId == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setSuffererId(suffererId);
        doctorPatient.setDoctorId(doctorId);
        if (iDoctorPatientService.addDoctorPatient(doctorPatient)) {
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }

    /**
     * 我的关注
     *
     * @return
     */
    @RequestMapping("/getDoctorAttentionForSuffer")
    @ResponseBody
    public AjaxModel getDoctorAttentionForSuffer(String token, PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token) || pageInfo == null) {
            model.setCode(AjaxCode.PARAM_ERROR);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        Integer suffererId = appToken.getUserId();
        if (suffererId == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        List<DoctorPatient> doctorPatientList = iDoctorPatientService.findDoctorPatientBySuffererId(suffererId, pageInfo);
        Map map = new HashMap();
        map.put("doctorPatientList", doctorPatientList);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }

    @RequestMapping("/getSufferAttentionForDoctor")
    @ResponseBody
    public AjaxModel getSufferAttentionForDoctor(String token, PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token) || pageInfo == null) {
            model.setCode(AjaxCode.PARAM_ERROR);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        Integer doctorId = appToken.getUserId();
        if (doctorId == null) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        List<DoctorPatient> doctorPatientList = iDoctorPatientService.findDoctorPatientByDoctorId(doctorId, pageInfo);
        Map map = new HashMap();
        map.put("doctorPatientList", doctorPatientList);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }
}
