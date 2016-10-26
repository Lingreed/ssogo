package com.boom.dianna.service.Impl;

import com.boom.dianna.dto.AccessToken;
import com.boom.dianna.dto.LoginPara;
import com.boom.dianna.dto.ResultMsg;
import com.boom.dianna.enumration.ResultStatusCode;
import com.boom.dianna.jwt.JwtHelper;
import com.boom.dianna.service.IJwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    @Override
    public Object getAccessToken(LoginPara loginPara) {
        ResultMsg resultMsg;

        //验证用户名密码
//            UserInfo user = userRepositoy.findUserInfoByName(loginPara.getUserName());
//            if (user == null)
//            {
//                resultMsg = new ResultMsg(ResultStatusCode.INVALID_PASSWORD.getErrcode(),
//                        ResultStatusCode.INVALID_PASSWORD.getErrmsg(), null);
//                return resultMsg;
//            }
//            else
//            {
//                String md5Password = MyUtils.getMD5(loginPara.getPassword()+user.getSalt());
//
//                if (md5Password.compareTo(user.getPassword()) != 0)
//                {
//                    resultMsg = new ResultMsg(ResultStatusCode.INVALID_PASSWORD.getErrcode(),
//                            ResultStatusCode.INVALID_PASSWORD.getErrmsg(), null);
//                    return resultMsg;
//                }
//            }

        //拼装accessToken
        String accessToken = JwtHelper.createJWT(loginPara.getUserName(), "11", loginPara.getIp(),
                expiresSecond * 1000, base64Security);
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
