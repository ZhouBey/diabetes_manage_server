package com.zpy.yy.service;

import com.zpy.yy.bean.DoctorPatient;
import com.zpy.yy.util.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public interface IDoctorPatientService {
    boolean addDoctorPatient(DoctorPatient doctorPatient);
    void deleteDoctorPatient(Integer id);
    boolean updateDoctorPatient(DoctorPatient doctorPatient);
    DoctorPatient findDoctorPatientById(Integer id);
    DoctorPatient findDoctorPatientByDoctorIdAndSuffererId(Integer suffererId, Integer doctorId);
    List<DoctorPatient> findDoctorPatientBySuffererId(Integer suffererId, PageInfo pageInfo);
    List<DoctorPatient> findDoctorPatientByDoctorId(Integer doctorId,PageInfo pageInfo);
}
