package com.zpy.yy.bean;

import java.io.Serializable;
import java.util.Date;

public class BloodSugarLog implements Serializable{
    private Integer id;
    private Integer suffererId;
    private Double sugarContent;
    private Date createD;
    private Date updateD;
    private Date deleteD;

    public Double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(Double sugarContent) {
        this.sugarContent = sugarContent;
    }

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

    public Integer getSuffererId() {
        return suffererId;
    }

    public void setSuffererId(Integer suffererId) {
        this.suffererId = suffererId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "BloodSugarLog{" +
                "id=" + id +
                ", suffererId=" + suffererId +
                ", sugarContent=" + sugarContent +
                ", createD=" + createD +
                ", updateD=" + updateD +
                ", deleteD=" + deleteD +
                '}';
    }
}
