package com.zpy.yy.service.impl;

import com.zpy.yy.bean.DoctorPatient;
import com.zpy.yy.dao.DoctorPatientDao;
import com.zpy.yy.service.IDoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/3 0003.
 */

@Service
public class DoctorPatientServiceImpl implements IDoctorPatientService {

    @Autowired
    DoctorPatientDao doctorPatientDao;

    @Override
    public boolean addDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDao.save(doctorPatient);
        return doctorPatient.getId() != null;
    }

    @Override
    public void deleteDoctorPatient(Integer id) {
        doctorPatientDao.deleteById(id);
    }

    @Override
    public boolean updateDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDao.update(doctorPatient);
        return true;
    }

    @Override
    public DoctorPatient findDoctorPatientById(Integer id) {
        return doctorPatientDao.findById(id);
    }

    @Override
    public DoctorPatient findDoctorPatientBySuffererId(Integer suffererId) {
        return doctorPatientDao.findDoctorPatientBySuffererId(suffererId);
    }

    @Override
    public DoctorPatient findDoctorPatientByDoctorId(Integer doctorId) {
        return doctorPatientDao.findDoctorPatientByDoctorId(doctorId);
    }
}
