package com.zpy.yy.controller;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 俊毅 on 2015/12/14.
 */
@Controller
@RequestMapping("/questionApi")
public class QuestionApiController extends BaseController {

    @Autowired
    IQuestionService iQuestionService;

    @Autowired
    ISuffererService iSuffererService;

    @Autowired
    IQuestionAndAnswerService iQuestionAndAnswerService;

    @Autowired
    IAppTokenService iAppTokenService;

    @Autowired
    IAnswerService iAnswerService;

    @Autowired
    IDoctorService iDoctorService;

    /**
     * 问答列表
     *
     * @param pageInfo
     * @return
     */
    @RequestMapping("/getQuestionList")
    @ResponseBody
    public AjaxModel getQuestionList(PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        List<Question> questionListPage = iQuestionService.getQuestionAllListPage(pageInfo);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < questionListPage.size(); i++) {
            Question question = questionListPage.get(i);
            int suffererId = question.getSuffererId();
            Sufferer sufferer = iSuffererService.findSufferById(suffererId);
            List<QuestionAndAnswer> questionAndAnswers = iQuestionAndAnswerService.getAnswersByQuestionId(question.getId());
            Map map = new HashMap();
            map.put("question", question);
            map.put("sufferer", sufferer);
            map.put("reply_count", questionAndAnswers.size());
            list.add(map);
        }
        model.setCode(AjaxCode.OK);
        Map map = new HashMap();
        map.put("questionListPage", list);
        map.put("pageInfo", pageInfo);
        model.setData(map);
        return model;
    }

    /**
     * 患者提问题
     *
     * @param token
     * @param title
     * @param content
     * @return
     */
    @RequestMapping("/askQuestion")
    @ResponseBody
    public AjaxModel askQuestion(String token, String title, String content) {
        AjaxModel model = new AjaxModel();
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.GET_ACCOUNT_ERR);
            return model;
        }
        Sufferer sufferer = iSuffererService.findSufferById(appToken.getUserId());
        if (sufferer == null) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        //可以提问题
        Question question = new Question();
        question.setSuffererId(sufferer.getId());
        question.setContent(content);
        question.setTitle(title);
        Integer questionId = iQuestionService.addQuestion(question);
        System.out.println("questionId=" + questionId);
        if (questionId != null) {
            Question questionExist = iQuestionService.findQuestionById(questionId);
            if (questionExist != null) {
                QuestionAndAnswer qa = new QuestionAndAnswer();
                qa.setQuestionId(questionExist.getId());
                iQuestionAndAnswerService.addQA(qa);
                model.setCode(AjaxCode.OK);
                return model;
            }
        }
        model.setCode(AjaxCode.ERROR);
        return model;
    }

    @RequestMapping("/getMyQuestions")
    @ResponseBody
    public AjaxModel getMyQuestions(String token, PageInfo pageInfo) {
        AjaxModel model = new AjaxModel();
        if (TextUtil.isEmpty(token)) {
            model.setCode(AjaxCode.TOKEN_IS_NULL);
            return model;
        }
        AppToken appToken = iAppTokenService.findAppTokenByToken(token);
        if (appToken == null) {
            model.setCode(AjaxCode.ACCOUNT_ALREADY_NOT_EXIST);
            return model;
        }
        List<Question> myQuestionList = iQuestionService.getQuestionListPageBySuffererId(appToken.getUserId(), pageInfo);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < myQuestionList.size(); i++) {
            Question question = myQuestionList.get(i);
            List<QuestionAndAnswer> questionAndAnswers = iQuestionAndAnswerService.getAnswersByQuestionId(question.getId());
            Map map = new HashMap();
            map.put("question", question);
            map.put("reply_count", questionAndAnswers.size());
            list.add(map);
        }
        Map map = new HashMap();
        map.put("questionListPage", list);
        map.put("pageInfo", pageInfo);
        model.setCode(AjaxCode.OK);
        model.setData(map);
        return model;
    }

    @RequestMapping("/getAnswersForOneQuestion")
    @ResponseBody
    public AjaxModel getAnswersForOneQuestion(Integer questionId) {
        AjaxModel model = new AjaxModel();
        if (questionId == null) {
            model.setCode(AjaxCode.ERROR);
            return model;
        }
        List<QuestionAndAnswer> questionAndAnswers = iQuestionAndAnswerService.getAnswersByQuestionId(questionId);
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < questionAndAnswers.size(); i++) {
            Answer answer = iAnswerService.findAnswerById(questionAndAnswers.get(i).getAnswerId());
            Doctor doctor = iDoctorService.findDoctorById(answer.getDoctorId());
            Map map = new HashMap();
            map.put("answer",answer);
            map.put("doctor",doctor);
            list.add(map);
        }
        model.setData(list);
        model.setCode(AjaxCode.OK);
        return model;
    }
}
