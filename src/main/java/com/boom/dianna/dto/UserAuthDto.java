package com.boom.dianna.dto;

import com.boom.dianna.model.Auth;

import java.util.List;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
public class UserAuthDto {

    private Long userId;
    private List<Long> authIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getAuthIds() {
        return authIds;
    }

    public void setAuthIds(List<Long> authIds) {
        this.authIds = authIds;
    }
}
