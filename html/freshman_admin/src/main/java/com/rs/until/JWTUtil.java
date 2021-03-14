package com.rs.until;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    /**key（按照签名算法的字节长度设置key)*/
    private final static String TOKEN_SECRET = "freshman_admin_yuan";
    /**过期时间（毫秒单位）*/
    private final static long EXPIRE_TIME = 1000 * 60 * 60;

        /**生成签名，1小时过期*/
        public static String createToken(Map<String,String> map) {
            return getToken(map, EXPIRE_TIME);
        }

        /**生成token，自定义过期时间 毫秒*/
        public static String createToken(Map<String,String> map,long expireDate) {
            return getToken(map, expireDate);
        }

    private static String getToken(Map<String, String> map, long expireDate) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + expireDate);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("ObjectMap", map)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**检验token是否正确*/
    public static Map<String, Object> verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("ObjectMap").asMap();
        } catch (Exception e){
            return null;
        }
    }
}
