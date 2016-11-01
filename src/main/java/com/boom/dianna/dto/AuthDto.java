package com.boom.dianna.dto;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
public class AuthDto {
    private long id;
    private String authName;

    public AuthDto() {
    }

    public AuthDto(long id, String authName) {
        this.id = id;
        this.authName = authName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }
}
