package com.zpy.yy.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class DoctorPatient implements Serializable {
    private Integer id;
    private Integer suffererId;
    private Integer doctorId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuffererId() {
        return suffererId;
    }

    public void setSuffererId(Integer suffererId) {
        this.suffererId = suffererId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

}
