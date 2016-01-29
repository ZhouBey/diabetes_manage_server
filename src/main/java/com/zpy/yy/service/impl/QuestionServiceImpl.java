package com.zpy.yy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.bean.Question;
import com.zpy.yy.dao.QuestionDao;
import com.zpy.yy.service.IQuestionService;
import com.zpy.yy.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2015/11/13 0013.
 */
@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionDao questionDao;


    @Override
    public int addQuestion(Question question) {
        questionDao.save(question);
        return question.getId();
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionDao.deleteById(id);
    }

    @Override
    public boolean updateQuestion(Question question) {
        questionDao.update(question);
        return true;
    }

    @Override
    public Question findQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    @Override
    public List<Question> getQuestionListPageBySuffererId(Integer suffererId,PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<Question> list = questionDao.getQuestionAllListPage();
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }

    @Override
    public List<Question> getQuestionAllListPage(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<Question> list = questionDao.getQuestionAllListPage();
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }
}
