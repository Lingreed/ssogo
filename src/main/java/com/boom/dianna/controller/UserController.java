package com.boom.dianna.controller;

import com.boom.dianna.dao.IOtherAuthDao;
import com.boom.dianna.dao.IUserAuthDao;
import com.boom.dianna.dao.IUserDao;
import com.boom.dianna.dao.IUserInfoDao;
import com.boom.dianna.dto.OtherAuthDto;
import com.boom.dianna.dto.ResultMsg;
import com.boom.dianna.dto.UserAuthDto;
import com.boom.dianna.dto.UserDto;
import com.boom.dianna.enumration.ResultStatusCode;
import com.boom.dianna.model.OtherAuth;
import com.boom.dianna.model.User;
import com.boom.dianna.model.UserInfo;
import com.boom.dianna.service.IJwtService;
import com.boom.dianna.utils.Md5Util;
import com.boom.dianna.utils.RedisPrefix;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private IOtherAuthDao otherAuthDao;

    @Autowired
    private IUserAuthDao userAuthDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${jwt.expiresSecond}")
    private long expiresSecond;

    /**
     * 测试token过滤器
     * @return
     */
    @RequestMapping("/user/getusers")
    public Object getUsers() {
        List<UserDto> userDtos = userDao.getAllUsers();
        return new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(),userDtos);
    }

    /**
     * 创建用户
     * @param userDto
     * @return
     */
    @RequestMapping("/user/add")
    public Object addUser(@RequestBody UserDto userDto){
        if(null != userDto && !userDto.getUserName().equals("")){
            if(null != userDao.findByUserName(userDto.getUserName())){
                return new ResultMsg(ResultStatusCode.EXIST_USERNAME.getErrcode(),
                        ResultStatusCode.EXIST_USERNAME.getErrmsg(),null);
            }

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
    @RequestMapping("/user/edituserinfo")
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

    /**
     * 设置用户启用或禁用
     * @param userDto
     * @return
     */
    @RequestMapping("/user/forbiden")
    public Object setForbiden(@RequestBody UserDto userDto){
        if(null != userDto){
            User user = userDao.findOne(userDto.getUserId());
            if(null != user){
                user.setEnabled(userDto.getEnabled());
                userDao.save(user);

                //把禁用的用户存入redis,启用的用户从redis中删去
                String userKey = String.format(RedisPrefix.ForbidenUser,user.getId());
                if(userDto.getEnabled()){
                    //启用
                    redisTemplate.delete(userKey);
                }else{
                    //禁用
                    redisTemplate.opsForValue().set(userKey,user.getUserName());
                    redisTemplate.expire(userKey, expiresSecond, TimeUnit.SECONDS);
                }

                return new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
            }
        }
        return new ResultMsg(ResultStatusCode.INVALID_PARAMETER.getErrcode(),ResultStatusCode.INVALID_PARAMETER.getErrmsg(),null);
    }

    @RequestMapping("/user/linkotherauth")
    public Object linkOtherAuth(@RequestBody OtherAuthDto otherAuthDto){
        OtherAuth save = new OtherAuth();
        BeanUtils.copyProperties(otherAuthDto,save);
        save.setAddTime(new Date());
        otherAuthDao.save(save);
        return new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
    }

//    @RequestMapping("/user/modifyauth")
//    public Object modifyUserAuth(@RequestBody UserAuthDto model){
//
//        return null;
//    }

}
