package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.Sufferer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuffererDao extends BaseMapper<Sufferer> {
    Sufferer findSuffererByPhone(String phone);
    List<Sufferer> getAllSuffererListPage();
}
