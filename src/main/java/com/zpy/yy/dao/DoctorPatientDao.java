package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.DoctorPatient;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorPatientDao extends BaseMapper<DoctorPatient> {
    DoctorPatient findDoctorPatientBySuffererId(Integer suffererId);
    DoctorPatient findDoctorPatientByDoctorId(Integer doctorId);
}
