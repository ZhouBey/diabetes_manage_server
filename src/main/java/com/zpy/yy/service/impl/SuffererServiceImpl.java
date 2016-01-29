package com.zpy.yy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpy.yy.bean.AppToken;
import com.zpy.yy.bean.HealthInfo;
import com.zpy.yy.bean.Sufferer;
import com.zpy.yy.dao.AppTokenDao;
import com.zpy.yy.dao.SuffererDao;
import com.zpy.yy.service.ISuffererService;
import com.zpy.yy.util.PageInfo;
import com.zpy.yy.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 患者serviceImpl
 *
 */
@Service
public class SuffererServiceImpl implements ISuffererService {

    @Autowired
    SuffererDao suffererDao;

    @Autowired
    AppTokenDao appTokenDao;

    @Value("#{properties['validity_app_tocken']}")
    String validity_app_tocken;

    @Override
    public boolean addSuffer(Sufferer sufferer) {
        suffererDao.save(sufferer);
        AppToken appToken = new AppToken();
        appToken.setRoleType(AppToken.TYPE_SUFFERER);
        appToken.setUserId(sufferer.getId());
        appToken.setToken(TextUtil.MD532());
        appToken.setDuration(Integer.parseInt(validity_app_tocken));
        appToken.setUpdateD(new Date());
        appTokenDao.save(appToken);
        return sufferer.getId()!=null;
    }

    @Override
    public void deleteSufferById(Integer id) {
        suffererDao.deleteById(id);
    }

    @Override
    public Sufferer findSufferById(Integer id) {
        return suffererDao.findById(id);
    }

    @Override
    public boolean updateSuffer(Sufferer sufferer) {
        suffererDao.update(sufferer);
        return true;
    }

    @Override
    public Sufferer findSuffererByPhone(String phone) {
        return suffererDao.findSuffererByPhone(phone);
    }

    @Override
    public boolean phoneExist(String phone) {
        Sufferer sufferer = suffererDao.findSuffererByPhone(phone);
        return sufferer!=null;
    }

    @Override
    public Sufferer getSuffererByPassword(String phone, String password) {
        Sufferer sufferer = suffererDao.findSuffererByPhone(phone);
        if(sufferer==null) {
            return null;
        }
        if(password.equals(sufferer.getPassword())) {
            AppToken appToken = new AppToken();
            appToken.setRoleType(AppToken.TYPE_SUFFERER);
            appToken.setUserId(sufferer.getId());
            appToken.setToken(TextUtil.MD532());
            appTokenDao.update(appToken);
            return sufferer;
        }
        return null;
    }

    @Override
    public List<Sufferer> getAllHealthInfoListPage(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getShowCount());
        List<Sufferer> list = suffererDao.getAllSuffererListPage();
        pageInfo.setTotalResult((int) ((Page) list).getTotal());
        pageInfo.setCurrentPage(((Page) list).getPageNum());
        pageInfo.setShowCount(((Page) list).getPageSize());
        return list;
    }
}
