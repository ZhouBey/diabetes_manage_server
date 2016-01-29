package com.zpy.yy.service;

import com.zpy.yy.bean.AppToken;

/**
 * Created by Administrator on 2015/11/11 0011.
 */
public interface IAppTokenService {
    void save(AppToken token);

    void updateAppToken(AppToken token);

    void deleteAppToken(Integer id);

    AppToken findAppTokenById(Integer id);

    AppToken findAppTokenByUserId(Integer user_id,Integer roleType);

    AppToken findAppTokenByToken(String token);
}
