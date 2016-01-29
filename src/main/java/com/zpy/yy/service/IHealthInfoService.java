package com.zpy.yy.service;

import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.util.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12 0012.
 */
public interface IHealthInfoService {
    boolean addHealthInfo(HealthInfo healthInfo);
    void deleteHealthInfo(Integer id);
    boolean updateHealthInfo(HealthInfo healthInfo);
    HealthInfo findHealthInfoById(Integer id);
    List<HealthInfo> searchHealthInfoListPage(PageInfo pageInfo);
}
