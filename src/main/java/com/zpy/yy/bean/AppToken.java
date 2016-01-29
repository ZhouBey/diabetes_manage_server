package com.zpy.yy.bean;

import java.io.Serializable;
import java.util.Date;

public class AppToken implements Serializable{
    public static final int TYPE_SUFFERER = 0;  //患者
    public static final int TYPE_DOCTOR = 1;    //医生

    private Integer id;
    private Integer userId;
    private String token;
    private Integer duration;
    private Integer roleType;
    private Date createD;
    private Date updateD;
    private Date deleteD;

    public Date getCreateD() {
        return createD;
    }

    public void setCreateD(Date createD) {
        this.createD = createD;
    }

    public Date getUpdateD() {
        return updateD;
    }

    public void setUpdateD(Date updateD) {
        this.updateD = updateD;
    }

    public Date getDeleteD() {
        return deleteD;
    }

    public void setDeleteD(Date deleteD) {
        this.deleteD = deleteD;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
