package com.zpy.yy.service;

import com.zpy.yy.bean.Question;
import com.zpy.yy.util.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
public interface IQuestionService {
    int addQuestion(Question question);
    void deleteQuestion(Integer id);
    boolean updateQuestion(Question question);
    Question findQuestionById(Integer id);
    List<Question> getQuestionListPageBySuffererId(Integer suffererId,PageInfo pageInfo);
    List<Question> getQuestionAllListPage(PageInfo pageInfo);
}
