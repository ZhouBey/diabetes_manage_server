package com.zpy.yy.bean;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable{
    private Integer id;
    private String title;
    private String content;
    private Integer suffererId;
    private Date createD;
    private Date updateD;
    private Date deleteD;

    public Integer getSuffererId() {
        return suffererId;
    }

    public void setSuffererId(Integer suffererId) {
        this.suffererId = suffererId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
