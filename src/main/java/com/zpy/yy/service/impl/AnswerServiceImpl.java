package com.zpy.yy.service.impl;

import com.zpy.yy.bean.Answer;
import com.zpy.yy.dao.AnswerDao;
import com.zpy.yy.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    AnswerDao answerDao;

    @Override
    public boolean addAnswer(Answer answer) {
        answerDao.save(answer);
        return answer.getId()!=null;
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
    public Answer findAnswerByDoctorId(Integer doctorId) {
        return answerDao.findAnswerByDoctorId(doctorId);
    }
}
