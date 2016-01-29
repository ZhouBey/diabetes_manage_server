package com.zpy.yy.service.impl;

import com.zpy.yy.bean.BloodSugarLog;
import com.zpy.yy.dao.BloodSugarLogDao;
import com.zpy.yy.service.IBloodSugarLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2015/11/12 0012.
 */
@Service
public class BloodSugarLogServiceImpl implements IBloodSugarLogService {

    @Autowired
    BloodSugarLogDao bloodSugarLogDao;

    @Override
    public boolean addBloodSugarLog(BloodSugarLog bloodSugarLog) {
        bloodSugarLogDao.save(bloodSugarLog);
        return bloodSugarLog.getId()!=null;
    }

    @Override
    public void deleteBloodSugarLog(Integer id) {
        bloodSugarLogDao.deleteById(id);
    }

    @Override
    public boolean updateBloodSugarLog(BloodSugarLog bloodSugarLog) {
        bloodSugarLogDao.update(bloodSugarLog);
        return true;
    }

    @Override
    public BloodSugarLog findBloodSugarLogByDateAndSuffererId(Date date,Integer suffererId) {
        return bloodSugarLogDao.findBloodSugarLogByDateAndSuffererId(date,suffererId);
    }

    @Override
    public BloodSugarLog findBloodSugarLogById(Integer id) {
        return bloodSugarLogDao.findById(id);
    }
}
