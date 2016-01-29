package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12 0012.
 */
@Repository
public interface DoctorDao extends BaseMapper<Doctor> {
    Doctor findDoctorByPhone(String phone);
    List<Doctor> getAllDoctorListPage();
}
