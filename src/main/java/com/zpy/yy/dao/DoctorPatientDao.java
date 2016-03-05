package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.DoctorPatient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorPatientDao extends BaseMapper<DoctorPatient> {
    List<DoctorPatient> findDoctorPatientBySuffererId(Integer suffererId);

    List<DoctorPatient> findDoctorPatientByDoctorId(Integer doctorId);

    DoctorPatient findDoctorPatientByDoctorIdAndSuffererId(@Param("suffererId")Integer suffererId, @Param("doctorId")Integer doctorId);
}
