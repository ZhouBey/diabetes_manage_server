package com.zpy.yy.service.impl;

import com.zpy.yy.bean.AppToken;
import com.zpy.yy.dao.AppTokenDao;
import com.zpy.yy.service.IAppTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppTokenServiceImpl implements IAppTokenService {

    @Autowired
    AppTokenDao appTokenDao;

    @Override
    public void save(AppToken token) {
        appTokenDao.save(token);
    }

    @Override
    public void updateAppToken(AppToken token) {
        appTokenDao.update(token);
    }

    @Override
    public void deleteAppToken(Integer id) {
        appTokenDao.deleteById(id);
    }

    @Override
    public AppToken findAppTokenById(Integer id) {
        return appTokenDao.findById(id);
    }

    @Override
    public AppToken findAppTokenByUserId(Integer user_id,Integer roleType) {
        return appTokenDao.findAppTokenByUserId(user_id,roleType);
    }

    @Override
    public AppToken findAppTokenByToken(String token) {
        return appTokenDao.findAppTokenByToken(token);
    }

}
