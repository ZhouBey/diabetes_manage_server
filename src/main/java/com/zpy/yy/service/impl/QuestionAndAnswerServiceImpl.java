package com.zpy.yy.service.impl;

import com.zpy.yy.bean.QuestionAndAnswer;
import com.zpy.yy.dao.QuestionAndAnswerDao;
import com.zpy.yy.service.IQuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
@Service
public class QuestionAndAnswerServiceImpl implements IQuestionAndAnswerService {

    @Autowired
    QuestionAndAnswerDao questionAndAnswerDao;

    @Override
    public boolean addQA(QuestionAndAnswer questionAndAnswer) {
        questionAndAnswerDao.save(questionAndAnswer);
        return questionAndAnswer.getId()!=null;
    }

    @Override
    public void deleteQA(Integer id) {
        questionAndAnswerDao.deleteById(id);
    }

    @Override
    public boolean updateQA(QuestionAndAnswer questionAndAnswer) {
        questionAndAnswerDao.update(questionAndAnswer);
        return true;
    }

    @Override
    public QuestionAndAnswer findQA(Integer id) {
        return questionAndAnswerDao.findById(id);
    }

    @Override
    public List<QuestionAndAnswer> getAnswersByQuestionId(Integer questionId) {
        return questionAndAnswerDao.getAnswersByQuestionId(questionId);
    }
}
