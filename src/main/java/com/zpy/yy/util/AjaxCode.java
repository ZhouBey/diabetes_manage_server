package com.zpy.yy.util;

public enum AjaxCode {

    OK("成功"),
    NEED_LOGIN("需要登录"),
    ACCOUNT_NOT_ADIMIN("您不是管理员"),
    ACCOUNT_ALREADY_EXIST("您输入的账户信息已存在"),
    ACCOUNT_ALREADY_NOT_EXIST("账户信息不存在"),
    PHONE_NOT_EXIST("手机号不存在"),
    LOGIN_ERROR("用户名或者密码错误"),
    GET_ACCOUNT_ERR("用户信息获取失败"),
    PASSWORD_ERROR("旧密码错误"),
    LOGIN_PASSWORD_ERROR("登录密码错误"),
    REGISTER_ERROR("您输入的注册信息有误，请重新输入"),
    CURRENT_BLOOD_SUGAR_LOG_EXIST("您今天已经添加过了血糖记录"),
    CURRENT_WEEK_NO_BLOOD_SUGAR_LOG("您这周没有添加血糖记录"),
    PARAM_ERROR("参数必要性检查失败"),
    ERROR("错误"),
    ACCOUNT_IS_REPLACED("您的账户已在别处登录"),
    PHOTO_IS_NULL("照片为空"),
    TOKEN_IS_NULL("token为空");


    private String msg;

    private AjaxCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
