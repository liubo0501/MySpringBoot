package com.anbot.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anbot.common.DataCache;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/******************************************************************************** 
** Copyright(c) 2014-2017 湖南万为智能机器人技术有限公司 All Rights Reserved. 
** @author liubo@anbot.cn
** 日期：2017/11/10
** 描述：JWT工具类
** 版本：v1.0
*********************************************************************************/
public class JWTUtil {
    
    /**
     *  日志
     */
    private static Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    
    private static String JWT_SECRET = "yuanchangjian199305221";

    // Sample method to construct a JWT

    public static String createJWT(String issuer, long ttlMillis) {

        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter
                .parseBase64Binary(JWT_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setIssuedAt(now).setIssuer(issuer).signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    /**
     *  Sample method to validate and read the JWT
     * @param jwt
     */
    public static Claims parseJWT(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as
        // expected)
        Claims claims = Jwts.parser()
                .setSigningKey(
                        DatatypeConverter.parseBase64Binary(JWT_SECRET))
                .parseClaimsJws(jwt).getBody();
        //System.out.println("Issuer: " + claims.getIssuer());
        //System.out.println("Expiration: " + claims.getExpiration());
        logger.debug("Issuer: {}",claims.getIssuer());
        logger.debug("Expiration: {}",claims.getExpiration());
        return claims;
    }
    
    public static void main(String[] args){
    	String token = createJWT("admin", 86400000);
    	System.out.println(token);
    	Claims claims = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1Mjg5NzI5NjIsImlzcyI6ImFkbWluIiwiZXhwIjoxNTI5MDU5MzYyfQ.tcWT9mf1gm4qK1l5Kqms-69Ixy3XiGEbWLLgwXdqAd8");
    	long regist_time = claims.getIssuedAt().getTime();
    	long token_time = claims.getExpiration().getTime();
    	long current = System.currentTimeMillis();
    	System.out.println(regist_time);
    	System.out.println(token_time);
    	System.out.println(current);
    	System.out.println(claims.getIssuer());
    }

	public static boolean volidateToken(String token) {
		Claims claims = parseJWT(token);
		String userName= claims.getIssuer();
		if(!token.equals(DataCache.tokenMap.get(userName))){
			return false;
		}
    	long token_time = claims.getExpiration().getTime();
    	long current = System.currentTimeMillis();
    	if(current < token_time){
    		return true;
    	}else{
    		return false;
    	}
	}
}
