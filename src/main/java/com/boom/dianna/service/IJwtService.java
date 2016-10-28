package com.boom.dianna.service;

import com.boom.dianna.dto.LoginPara;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Author: lin.xj
 * Date: 2016-10-26
 * Description:
 */
public interface IJwtService {
    /**
     * 登录并获取accesstoken
     * @param loginPara
     * @return
     */
    Object getAccessToken(LoginPara loginPara);

    /**
     * 验证accesstoken，返回null代表验证失败
     * @param accessToken
     * @return
     */
    String validAccessToken(String accessToken) throws JsonProcessingException;
}
