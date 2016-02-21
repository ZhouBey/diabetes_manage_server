package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
@Repository
public interface AnswerDao extends BaseMapper<Answer> {
    List<Answer> findAnswerByDoctorId(Integer doctorId);
}
