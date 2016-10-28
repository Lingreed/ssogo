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
public class User extends BaseModel {

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private Boolean enabled;

    private String info;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
