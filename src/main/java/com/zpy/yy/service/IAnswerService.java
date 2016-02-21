package com.zpy.yy.service;

import com.zpy.yy.bean.Answer;
import com.zpy.yy.util.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
public interface IAnswerService {
    boolean addAnswer(Answer answer);

    void deleteAnswer(Integer id);

    boolean updateAnswer(Answer answer);

    Answer findAnswerById(Integer id);

    List<Answer> findAnswerByDoctorId(Integer doctorId, PageInfo pageInfo);
}
