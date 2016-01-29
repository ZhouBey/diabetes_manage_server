package com.zpy.yy.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/2 0002.
 */
public class Opinion implements Serializable {
    private Integer id;
    private String phone;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
