package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.BloodSugarLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BloodSugarLogDao extends BaseMapper<BloodSugarLog>{
    BloodSugarLog findBloodSugarLogByDateAndSuffererId(@Param("date")Date date, @Param("suffererId")Integer suffererId);
}
