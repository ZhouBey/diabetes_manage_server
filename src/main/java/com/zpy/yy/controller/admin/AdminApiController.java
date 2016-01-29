package com.zpy.yy.controller.admin;

import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.Doctor;
import com.zpy.yy.service.IDoctorService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/adminApiController")
public class AdminApiController extends BaseController {
    @Autowired
    IDoctorService iDoctorService;

    @RequestMapping("/adminLogin")
    @ResponseBody
    public AjaxModel adminLogin(String phone,String password) {
        AjaxModel model = new AjaxModel();
        if (!iDoctorService.phoneExist(phone)) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        Doctor doctor = iDoctorService.findDoctorByPassword(phone, password);
        if (doctor == null) {
            model.setCode(AjaxCode.LOGIN_ERROR);
            return model;
        }
        Integer id = doctor.getId();
        if(3 == id) {
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ACCOUNT_NOT_ADIMIN);
        return model;
    }
}
