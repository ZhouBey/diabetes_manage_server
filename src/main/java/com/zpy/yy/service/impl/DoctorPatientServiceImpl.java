package com.zpy.yy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpy.yy.bean.DoctorPatient;
import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.dao.DoctorPatientDao;
import com.zpy.yy.service.IDoctorPatientService;
import com.zpy.yy.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public DoctorPatient findDoctorPatientByDoctorIdAndSuffererId(Integer suffererId, Integer doctorId) {
        return doctorPatientDao.findDoctorPatientByDoctorIdAndSuffererId(suffererId, doctorId);
    }

    @Override
    public List<DoctorPatient> findDoctorPatientBySuffererId(Integer suffererId, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<DoctorPatient> list = doctorPatientDao.findDoctorPatientBySuffererId(suffererId);
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }

    @Override
    public List<DoctorPatient> findDoctorPatientByDoctorId(Integer doctorId, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<DoctorPatient> list = doctorPatientDao.findDoctorPatientByDoctorId(doctorId);
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }
}
