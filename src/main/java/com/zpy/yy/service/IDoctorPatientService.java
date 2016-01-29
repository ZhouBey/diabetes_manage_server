package com.zpy.yy.service;

import com.zpy.yy.bean.DoctorPatient;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public interface IDoctorPatientService {
    boolean addDoctorPatient(DoctorPatient doctorPatient);
    void deleteDoctorPatient(Integer id);
    boolean updateDoctorPatient(DoctorPatient doctorPatient);
    DoctorPatient findDoctorPatientById(Integer id);
    DoctorPatient findDoctorPatientBySuffererId(Integer suffererId);
    DoctorPatient findDoctorPatientByDoctorId(Integer doctorId);
}
