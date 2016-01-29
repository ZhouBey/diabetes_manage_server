package com.zpy.yy.controller;

import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.DoctorPatient;
import com.zpy.yy.dao.DoctorPatientDao;
import com.zpy.yy.service.IDoctorPatientService;
import com.zpy.yy.util.AjaxCode;
import com.zpy.yy.util.AjaxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
@Controller
@RequestMapping("/doctorPatientApi")
public class DoctorPatientApiController extends BaseController {

    @Autowired
    IDoctorPatientService iDoctorPatientService;

    @RequestMapping("/addDoctorPatient")
    @ResponseBody
    public AjaxModel addDoctorPatient(Integer suffererId, Integer doctorId, Integer isAgree) {
        AjaxModel model = new AjaxModel();
        if (suffererId == null || doctorId == null) {
            model.setCode(AjaxCode.PARAM_ERROR);
            return model;
        }
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setSuffererId(suffererId);
        doctorPatient.setDoctorId(doctorId);
        if(isAgree!=null) {
            doctorPatient.setIsAgree(isAgree);
        }
        if(iDoctorPatientService.addDoctorPatient(doctorPatient)) {
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }
}
