package com.zpy.yy.service;

import com.zpy.yy.bean.Sufferer;
import com.zpy.yy.util.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/11/10 0010.
 */
public interface ISuffererService {
    boolean addSuffer(Sufferer sufferer);

    void deleteSufferById(Integer id);

    Sufferer findSufferById(Integer id);

    boolean updateSuffer(Sufferer sufferer);

    Sufferer findSuffererByPhone(String phone);

    boolean phoneExist(String phone);

    /**
     * 通过手机号和密码获取患者信息
     *
     * @param phone
     * @param password
     * @return
     */
    Sufferer getSuffererByPassword(String phone, String password);

    List<Sufferer> getAllHealthInfoListPage(PageInfo pageInfo);
}
