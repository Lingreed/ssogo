package com.boom.dianna.controller;

import com.boom.dianna.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lin.xj
 * Date: 2016-09-28
 * Description:
 */
@RestController
public class JWTController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(){

        return null;
    }
}
