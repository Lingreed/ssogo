package com.boom.dianna.service.Impl;

import com.boom.dianna.dao.IAccessTokenDao;
import com.boom.dianna.dao.IUserDao;
import com.boom.dianna.dto.AccessToken;
import com.boom.dianna.dto.LoginPara;
import com.boom.dianna.dto.ResultMsg;
import com.boom.dianna.enumration.ResultStatusCode;
import com.boom.dianna.jwt.JwtHelper;
import com.boom.dianna.model.AccessLog;
import com.boom.dianna.model.User;
import com.boom.dianna.service.IJwtService;
import com.boom.dianna.utils.Md5Util;
import com.boom.dianna.utils.RedisPrefix;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Author: lin.xj
 * Date: 2016-10-26
 * Description:
 */
@Service
public class JwtServiceImpl implements IJwtService {

    @Value("${jwt.base64Security}")
    private String base64Security;

    @Value("${jwt.expiresSecond}")
    private long expiresSecond;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IAccessTokenDao accessTokenDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object getAccessToken(LoginPara loginPara) {
        ResultMsg resultMsg = null;
        User user = userDao.findByUserName(loginPara.getUserName());
        if(null != user){
            //验证用户是否处于启用状态
            if(!user.getEnabled()){
                return new ResultMsg(ResultStatusCode.DISABLED_USER.getErrcode(),
                        ResultStatusCode.DISABLED_USER.getErrmsg(),null);
            }
            //验证密码
            String md5Password = Md5Util.encode(loginPara.getPassword());
            if(user.getEnabled() && md5Password.equals(user.getPwd())){
                //拼装accessToken
                String accessToken = JwtHelper.createJWT(loginPara.getUserName(), String.valueOf(user.getId()), loginPara.getIp(),
                        expiresSecond * 1000, base64Security);

                //保存登录记录accesslog
                AccessLog accessLog = new AccessLog();
                accessLog.setUserId(user.getId());
                accessLog.setEntryAddress(loginPara.getIp());
                accessLog.setAccessTime(new Date());
                accessTokenDao.save(accessLog);

                //返回accessToken
                AccessToken accessTokenEntity = new AccessToken();
                accessTokenEntity.setAccess_token(accessToken);
                accessTokenEntity.setExpires_in(expiresSecond);
                accessTokenEntity.setToken_type("bearer");
                resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),
                        ResultStatusCode.OK.getErrmsg(), accessTokenEntity);
                return resultMsg;
            }
        }
        return new ResultMsg(ResultStatusCode.INVALID_PASSWORD.getErrcode(),
                ResultStatusCode.INVALID_PASSWORD.getErrmsg(),null);
    }

    @Override
    public String validAccessToken(String accessToken) throws JsonProcessingException {
        Claims claims = JwtHelper.parseJWT(accessToken,base64Security);
        if(null != claims){
            //token解析成功
            //从redis中判断用户是否被禁用
            String userKey = String.format(RedisPrefix.ForbidenUser,claims.get("userId"));
            if(null == redisTemplate.opsForValue().get(userKey)){
                //用户不存在与redis的禁用名单中，返回token中相关信息
                return objectMapper.writeValueAsString(claims);
            }
        }
        return null;
    }
}
