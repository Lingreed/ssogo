package com.boom.dianna.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Author: lin.xj
 * Date: 2016-09-28
 * Description: 构造及解析jwt
 */
public class JwtHelper {
    public static Claims parseJWT(String jsonWebToken,String base64Security){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(base64Security)
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch (Exception ex){
            return null;
        }

    }

    public static String createJWT(String userName, String userId, String ip, long TTLMillis, String base64Security){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                                            .claim("userName",userName)
                                            .claim("userId", userId)
                                            .claim("ip", ip)
                                            .signWith(signatureAlgorithm, key);
        //添加token过期时间
        if(TTLMillis >= 0){
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生存JWT
        return builder.compact();
    }
}
