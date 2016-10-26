package com.boom.dianna.dto;

/**
 * Author: lin.xj
 * Date: 2016-10-25
 * Description:
 */
public class ResultMsg {
    private int errcode;
    private String errmsg;
    private Object data;

    public ResultMsg() {
    }

    public ResultMsg(int errcode, String errmsg, Object data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
