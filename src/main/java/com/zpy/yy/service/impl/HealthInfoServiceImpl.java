package com.zpy.yy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.dao.HealthInfoDao;
import com.zpy.yy.service.IHealthInfoService;
import com.zpy.yy.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12 0012.
 */
@Service
public class HealthInfoServiceImpl implements IHealthInfoService {
    @Autowired
    HealthInfoDao healthInfoDao;

    @Override
    public boolean addHealthInfo(HealthInfo healthInfo) {
        healthInfoDao.save(healthInfo);
        return healthInfo.getId()!=null;
    }

    @Override
    public void deleteHealthInfo(Integer id) {
        healthInfoDao.deleteById(id);
    }

    @Override
    public boolean updateHealthInfo(HealthInfo healthInfo) {
        healthInfoDao.update(healthInfo);
        return true;
    }

    @Override
    public HealthInfo findHealthInfoById(Integer id) {
        return healthInfoDao.findById(id);
    }

    @Override
    public List<HealthInfo> searchHealthInfoListPage(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<HealthInfo> list = healthInfoDao.getAllHealthInfoListPage();
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }
}
