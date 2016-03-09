package com.zpy.yy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.Doctor;
import com.zpy.yy.dao.AppTokenDao;
import com.zpy.yy.dao.DoctorDao;
import com.zpy.yy.service.IDoctorService;
import com.zpy.yy.util.PageInfo;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 医生serviceImpl
 *
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    AppTokenDao appTokenDao;

    @Value("#{properties['validity_app_tocken']}")
    String validity_app_tocken;

    @Override
    public boolean addDoctor(Doctor doctor) {
        doctorDao.save(doctor);
        AppToken appToken = new AppToken();
        appToken.setRoleType(AppToken.TYPE_DOCTOR);
        appToken.setUserId(doctor.getId());
        appToken.setToken(TextUtil.MD532());
        appToken.setDuration(Integer.parseInt(validity_app_tocken));
        appToken.setUpdateD(new Date());
        appTokenDao.save(appToken);
        return doctor.getId()!=null;
    }

    @Override
    public void deleteDoctor(Integer id) {
        doctorDao.deleteById(id);
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        doctorDao.update(doctor);
        return true;
    }

    @Override
    public Doctor findDoctorById(Integer id) {
        return doctorDao.findById(id);
    }

    @Override
    public Doctor findDoctorByPhone(String phone) {
        return doctorDao.findDoctorByPhone(phone);
    }

    @Override
    public boolean phoneExist(String phone) {
        Doctor doctor = doctorDao.findDoctorByPhone(phone);
        return doctor!=null;
    }

    @Override
    public Doctor findDoctorByPassword(String phone, String password) {
        Doctor doctor = doctorDao.findDoctorByPhone(phone);
        if(doctor==null) {
            return null;
        }
        if(!password.equals(doctor.getPassword())) {
            return null;
        }
        AppToken appToken = new AppToken();
        appToken.setRoleType(AppToken.TYPE_DOCTOR);
        appToken.setUserId(doctor.getId());
        appToken.setToken(TextUtil.MD532());
        appTokenDao.update(appToken);
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctorListPage(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<Doctor> list = doctorDao.getAllDoctorListPage();
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }

    @Override
    public List<Doctor> searchDoctors(String keyWord, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<Doctor> list = doctorDao.searchDoctors(keyWord);
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }
}
