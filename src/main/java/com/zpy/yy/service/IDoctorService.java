package com.zpy.yy.service;

import com.zpy.yy.bean.Doctor;
import com.zpy.yy.util.PageInfo;

import javax.print.Doc;
import java.util.List;

/**
 * Created by Administrator on 2015/11/12 0012.
 */
public interface IDoctorService {
    boolean addDoctor(Doctor doctor);
    void deleteDoctor(Integer id);
    boolean updateDoctor(Doctor doctor);
    Doctor findDoctorById(Integer id);
    Doctor findDoctorByPhone(String phone);
    boolean phoneExist(String phone);

    /**
     * 通过手机号和密码获取医生信息
     * @param phone
     * @param password
     * @return
     */
    Doctor findDoctorByPassword(String phone,String password);
    List<Doctor> getAllDoctorListPage(PageInfo pageInfo);
    List<Doctor> searchDoctors(String keyWord,PageInfo pageInfo);
}
