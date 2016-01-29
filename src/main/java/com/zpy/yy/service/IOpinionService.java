package com.zpy.yy.service;

import com.zpy.yy.bean.Opinion;

/**
 * Created by Administrator on 2015/12/2 0002.
 */
public interface IOpinionService {
    boolean addOpinion(Opinion opinion);
    void deleteOpinion(Integer id);
    boolean updateOpinion(Opinion opinion);
    Opinion findOpinionById(Integer id);
}
