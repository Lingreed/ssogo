package com.boom.dianna.service;

import com.boom.dianna.dto.LoginPara;

/**
 * Author: lin.xj
 * Date: 2016-10-26
 * Description:
 */
public interface IJwtService {
    Object getAccessToken(LoginPara loginPara);
}
