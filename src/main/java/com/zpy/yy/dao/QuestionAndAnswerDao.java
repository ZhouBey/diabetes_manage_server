package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.bean.Question;
import com.zpy.yy.bean.QuestionAndAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
@Repository
public interface QuestionAndAnswerDao extends BaseMapper<QuestionAndAnswer> {
    List<QuestionAndAnswer> getAnswersByQuestionId(Integer questionId);
    QuestionAndAnswer getAnswersByAnswerId(Integer answerId);
}
