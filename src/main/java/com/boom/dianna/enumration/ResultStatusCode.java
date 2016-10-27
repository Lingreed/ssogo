package com.boom.dianna.enumration;

/**
 * Author: lin.xj
 * Date: 2016-10-25
 * Description:
 */
public enum ResultStatusCode {
    OK(0, "OK"),
    SYSTEM_ERR(30001, "System error"),
    INVALID_PARAMETER(30002, "Invalid parameter!"),
    INVALID_CLIENTID(30003, "Invalid clientid"),
    INVALID_PASSWORD(30004, "User name or password is incorrect"),
    INVALID_CAPTCHA(30005, "Invalid captcha or captcha overdue"),
    INVALID_TOKEN(30006, "Invalid token");

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
