package com.zpy.yy.dao;

import com.zpy.yy.base.BaseMapper;
import com.zpy.yy.bean.AppToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppTokenDao extends BaseMapper<AppToken> {
    AppToken findAppTokenByToken(String token);
    AppToken findAppTokenByUserId(@Param("userId")Integer userId,@Param("roleType")Integer roleType);
}
