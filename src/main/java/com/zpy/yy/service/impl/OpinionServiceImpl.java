package com.zpy.yy.service.impl;

import com.zpy.yy.bean.Opinion;
import com.zpy.yy.dao.OpinionDao;
import com.zpy.yy.service.IOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/2 0002.
 */
@Service
public class OpinionServiceImpl implements IOpinionService {

    @Autowired
    OpinionDao opinionDao;

    @Override
    public boolean addOpinion(Opinion opinion) {
        opinionDao.save(opinion);
        return opinion.getId() != null;
    }

    @Override
    public void deleteOpinion(Integer id) {
        opinionDao.deleteById(id);
    }

    @Override
    public boolean updateOpinion(Opinion opinion) {
        opinionDao.update(opinion);
        return true;
    }

    @Override
    public Opinion findOpinionById(Integer id) {
        Opinion opinion = opinionDao.findById(id);
        return opinion;
    }
}
