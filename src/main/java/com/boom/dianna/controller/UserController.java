package com.boom.dianna.controller;

import com.boom.dianna.dao.IUserDao;
import com.boom.dianna.dao.IUserInfoDao;
import com.boom.dianna.dto.ResultMsg;
import com.boom.dianna.dto.UserDto;
import com.boom.dianna.enumration.ResultStatusCode;
import com.boom.dianna.model.User;
import com.boom.dianna.model.UserInfo;
import com.boom.dianna.utils.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Author: lin.xj
 * Date: 2016-10-25
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserInfoDao userInfoDao;

    /**
     * 测试token过滤器
     * @return
     */
    @RequestMapping("/user/getusers")
    public Object getUsers() {
        System.out.println("---------------------------------");
        return new ResultMsg();
    }

    /**
     * 创建用户
     * @param userDto
     * @return
     */
    @RequestMapping("/user/add")
    public Object addUser(@RequestBody UserDto userDto){
        if(null != userDto && !userDto.getUserName().equals("")){
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            user.setAddTime(new Date());
            user.setEnabled(true);
            user.setPwd(Md5Util.encode(userDto.getPwd()));
            User save = userDao.save(user);

            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(save.getId());
            userInfoDao.save(userInfo);

            return new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(),null);
        }else{
            return new ResultMsg(ResultStatusCode.INVALID_PARAMETER.getErrcode(),
                    ResultStatusCode.INVALID_PARAMETER.getErrmsg(),null);
        }
    }

    /**
     * 修改用户信息
     * @param userDto
     * @return
     */
    @RequestMapping("/userinfo/edit")
    public Object editUserInfo(@RequestBody UserDto userDto){
        if(null != userDto){
            UserInfo userInfo = userInfoDao.findByUserId(userDto.getUserId());
            if(null != userInfo){
                BeanUtils.copyProperties(userDto,userInfo);
                userInfoDao.save(userInfo);
                return new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
            }
        }
        return new ResultMsg(ResultStatusCode.INVALID_PARAMETER.getErrcode(),ResultStatusCode.INVALID_PARAMETER.getErrmsg(),null);
    }

}
