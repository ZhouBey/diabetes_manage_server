package com.zpy.yy.service;

import com.zpy.yy.bean.Answer;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
public interface IAnswerService {
    boolean addAnswer(Answer answer);
    void deleteAnswer(Integer id);
    boolean updateAnswer(Answer answer);
    Answer findAnswerById(Integer id);
    Answer findAnswerByDoctorId(Integer doctorId);
}
