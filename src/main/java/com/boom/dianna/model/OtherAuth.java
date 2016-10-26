package com.boom.dianna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Author: lin.xj
 * Date: 2016-10-26
 * Description:
 */
@Entity
public class OtherAuth extends BaseModel {

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private String authId;

    @Temporal(TemporalType.DATE)
    private Date addTime;

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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
