package com.boom.dianna.controller;

import com.boom.dianna.dto.LoginPara;
import com.boom.dianna.service.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: lin.xj
 * Date: 2016-09-28
 * Description:
 */
@RestController
public class JWTController {

    @Autowired
    private IJwtService jwtService;

    @RequestMapping("/login")
    public Object login(HttpServletRequest request, @RequestBody LoginPara loginPara) {
        String ip = request.getRemoteAddr();
        loginPara.setIp(ip);
        return jwtService.getAccessToken(loginPara);
    }
}
