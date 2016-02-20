package com.zpy.yy.controller;

import com.zpy.yy.base.BaseConfig;
import com.zpy.yy.base.BaseController;
import com.zpy.yy.bean.*;
import com.zpy.yy.service.IAnswerService;
import com.zpy.yy.service.IAppTokenService;
import com.zpy.yy.service.IDoctorService;
import com.zpy.yy.service.IQuestionAndAnswerService;
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

@Controller
@RequestMapping("/doctorApi")
public class DoctorApiController extends BaseController {

    @Autowired
    IDoctorService iDoctorService;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    IAnswerService iAnswerService;

    @Autowired
    IQuestionAndAnswerService iQuestionAndAnswerService;

    /**
     * 医生注册
     *
     * @param phone
     * @param password
     * @param hospital
     * @param certificate_image
     * @return
     */
    @RequestMapping("/doctorRegister")
    @ResponseBody
    public AjaxModel doctorRegister(String name, String phone, String password, String hospital,
                                    String certificate_image, String info, String post, String sex, String birthday) {
        AjaxModel model = new AjaxModel();
        if (iDoctorService.phoneExist(phone)) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_EXIST);
            return model;
        }
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setPhone(phone);
        doctor.setPassword(password);
        doctor.setHospital(hospital);
        doctor.setCertificateImage(certificate_image);
        doctor.setInfo(info);
        doctor.setPost(post);
        doctor.setSex(TextUtil.getSexInt(sex));
        doctor.setBirthday(TextUtil.str2Date(birthday));
        if (iDoctorService.addDoctor(doctor)) {
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }

    /**
     * 医生登录
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/doctorLogin")
    @ResponseBody
    public AjaxModel doctorLogin(String phone, String password) {
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
        Map map = new HashMap();
        AppToken appToken = iAppTokenService.findAppTokenByUserId(doctor.getId(), BaseConfig.ROLE_TYPE_FOR_DOCTOR);
        map.put("appToken", appToken);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }

    @RequestMapping("/getDoctorInfo")
    @ResponseBody
    public AjaxModel getDoctorInfo(String token) {
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
        Doctor doctor = iDoctorService.findDoctorById(userId);
        Map map = new HashMap();
        map.put("doctor", doctor);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }

    /**
     * 医生回复患者提问
     *
     * @param token
     * @param content
     * @return
     */
    @RequestMapping("/replyQuestion")
    @ResponseBody
    public AjaxModel replyQuestion(String token, Integer questionId, String content) {
        AjaxModel model = new AjaxModel();
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        Doctor doctor = iDoctorService.findDoctorById(appToken.getUserId());
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setDoctorId(doctor.getId());
        if (iAnswerService.addAnswer(answer)) {
            QuestionAndAnswer qa = new QuestionAndAnswer();
            qa.setQuestionId(questionId);
            qa.setAnswerId(answer.getId());
            iQuestionAndAnswerService.updateQA(qa);
            model.setCode(AjaxCode.OK);
            return model;
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }

    @RequestMapping("/getDoctorsListPage")
    @ResponseBody
    public AjaxModel getDoctorsListPage(PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        List<Doctor> doctors = iDoctorService.getAllDoctorListPage(pageInfo);
        Map map = new HashMap();
        map.put("doctors", doctors);
        map.put("pageInfo", pageInfo);
        model.setData(map);
        model.setCode(AjaxCode.OK);
        return model;
    }

}
