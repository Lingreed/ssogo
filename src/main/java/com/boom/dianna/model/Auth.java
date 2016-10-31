package com.boom.dianna.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
@Entity
public class Auth extends BaseModel {

    @Column(nullable = false, unique = true)
    private String authName;

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }
}
