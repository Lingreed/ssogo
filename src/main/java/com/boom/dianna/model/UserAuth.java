package com.boom.dianna.model;

import javax.persistence.Entity;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
@Entity
public class UserAuth extends BaseModel {
    private long userId;
    private long authId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAuthId() {
        return authId;
    }

    public void setAuthId(long authId) {
        this.authId = authId;
    }
}
