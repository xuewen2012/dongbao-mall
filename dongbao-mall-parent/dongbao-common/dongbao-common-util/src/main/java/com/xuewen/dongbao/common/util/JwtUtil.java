package com.xuewen.dongbao.common.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/27
 */
public class JwtUtil {

    private static final String secret = "asjklsdjf fff";

    public static String createToken(String subject) {
        String token = Jwts.builder().setSubject(subject).signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .compact();
        return token;
    }

    public static String parseToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String subject = body.getSubject();
        return subject;
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "何学文";

        String token = createToken(name);
        System.out.println(token);

        String srcStr = parseToken(token);
        System.out.println("解析出来：" + srcStr);
        TimeUnit.SECONDS.sleep(4);
        srcStr = parseToken(token);
        System.out.println("ahhaha" + srcStr);
    }
}
