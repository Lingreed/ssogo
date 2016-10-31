package com.boom.dianna.dto;

import com.boom.dianna.model.Auth;

import java.util.List;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
public class UserAuthDto {
    private List<Auth> auths;

    public List<Auth> getAuths() {
        return auths;
    }

    public void setAuths(List<Auth> auths) {
        this.auths = auths;
    }
}
