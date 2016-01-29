package com.zpy.yy.service;

import com.zpy.yy.bean.BloodSugarLog;

import java.util.Date;
import java.util.List;

public interface IBloodSugarLogService {
    boolean addBloodSugarLog(BloodSugarLog bloodSugarLog);
    void deleteBloodSugarLog(Integer id);
    boolean updateBloodSugarLog(BloodSugarLog bloodSugarLog);
    BloodSugarLog findBloodSugarLogById(Integer id);
    BloodSugarLog findBloodSugarLogByDateAndSuffererId(Date date,Integer suffererId);
}
