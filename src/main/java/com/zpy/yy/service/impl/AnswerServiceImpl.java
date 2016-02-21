package com.zpy.yy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpy.yy.bean.Answer;
import com.zpy.yy.bean.Question;
import com.zpy.yy.dao.AnswerDao;
import com.zpy.yy.service.IAnswerService;
import com.zpy.yy.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    AnswerDao answerDao;

    @Override
    public boolean addAnswer(Answer answer) {
        answerDao.save(answer);
        return answer.getId() != null;
    }

    @Override
    public void deleteAnswer(Integer id) {
        answerDao.deleteById(id);
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        answerDao.update(answer);
        return true;
    }

    @Override
    public Answer findAnswerById(Integer id) {
        return answerDao.findById(id);
    }

    @Override
    public List<Answer> findAnswerByDoctorId(Integer doctorId, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<Answer> list = answerDao.findAnswerByDoctorId(doctorId);
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }
}
