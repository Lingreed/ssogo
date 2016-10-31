package com.boom.dianna.controller;

import com.boom.dianna.dao.IAuthDao;
import com.boom.dianna.dto.AuthDto;
import com.boom.dianna.dto.ResultMsg;
import com.boom.dianna.enumration.ResultStatusCode;
import com.boom.dianna.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
@RestController
public class AuthController {

    @Autowired
    private IAuthDao authDao;

    @RequestMapping("/auth/add")
    public Object addAuth(@RequestBody AuthDto authDto){
        Auth auth = new Auth();
        auth.setAuthName(authDto.getAuthName());
        if(null == authDao.save(auth)){
            return new ResultMsg(ResultStatusCode.INVALID_PARAMETER.getErrcode(),ResultStatusCode.INVALID_PARAMETER.getErrmsg(),null);
        }
        return new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
    }

    @RequestMapping("/auth/delete/{id}")
    public Object deleteAuth(@PathVariable("id") Long id){
        authDao.delete(id);
        return new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
    }

    @RequestMapping("/auth/list")
    public Object authList(){
        List<Auth> authList = authDao.findAll();
        return new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),authList);
    }
}
