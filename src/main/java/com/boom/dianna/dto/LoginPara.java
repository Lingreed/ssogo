package com.boom.dianna.dto;

/**
 * Author: lin.xj
 * Date: 2016-09-28
 * Description: 登录获取token时，所需要的认证信息类
 */
public class LoginPara {
    private String userName;
    private String password;
    private String ip;//后台通过request取

    //验证码，之后可能要加
//    private String captchaCode;
//    private String captchaValue;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
