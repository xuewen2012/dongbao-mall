package com.xuewen.dongbao.portal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.xuewen")
@MapperScan("com.xuewen.dongbao.ums.mapper")
public class DongbaoPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongbaoPortalWebApplication.class, args);
    }


}
