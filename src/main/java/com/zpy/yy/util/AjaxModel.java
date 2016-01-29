package com.zpy.yy.util;

/**
 * Created by Administrator on 2015/11/11 0011.
 */
public class AjaxModel {

    private AjaxCode code;
    private String msg;
    private Object data;

    public AjaxCode getCode() {
        return code;
    }

    public void setCode(AjaxCode code) {
        this.code = code;
        this.msg = code.getMsg();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
