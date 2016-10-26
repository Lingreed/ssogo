package com.boom.dianna.controller;

import com.boom.dianna.dto.ResultMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lin.xj
 * Date: 2016-10-25
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getusers")
    public Object getUsers()
    {
        System.out.println("---------------------------------");
        return new ResultMsg();
    }
}
