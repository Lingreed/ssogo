package com.boom.dianna.dto;

import java.io.Serializable;

/**
 * Author: lin.xj
 * Date: 2016-10-28
 * Description:
 */
public class OtherAuthDto implements Serializable {
    //在本系统的Id
    private long userId;
    //在其他系统的id
    private String authId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }
}
