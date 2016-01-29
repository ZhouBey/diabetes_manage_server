package com.zpy.yy.service;

import com.zpy.yy.bean.QuestionAndAnswer;

import java.util.List;

public interface IQuestionAndAnswerService {
    boolean addQA(QuestionAndAnswer questionAndAnswer);
    void deleteQA(Integer id);
    boolean updateQA(QuestionAndAnswer questionAndAnswer);
    QuestionAndAnswer findQA(Integer id);
    List<QuestionAndAnswer> getAnswersByQuestionId(Integer questionId);
}
