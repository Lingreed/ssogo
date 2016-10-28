package com.boom.dianna.enumration;

/**
 * Author: lin.xj
 * Date: 2016-10-25
 * Description:
 */
public enum ResultStatusCode {
    OK(0, "OK"),
    INVALID_TOKEN(30000, "Invalid token"),
    SYSTEM_ERR(30001, "System error"),
    INVALID_PARAMETER(30002, "Invalid parameter!"),
    DISABLED_USER(30003, "User has been disabled!"),
    INVALID_PASSWORD(30004, "User name or password is incorrect"),
    EXIST_USERNAME(30005, "Username is existing!"),
    INVALID_CAPTCHA(30006, "Invalid captcha or captcha overdue");

    private int errcode;
    private String errmsg;

    ResultStatusCode(int Errode, String ErrMsg)
    {
        this.errcode = Errode;
        this.errmsg = ErrMsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
