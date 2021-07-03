package com.xuewen.dongbaoums.ums.service;

import com.xuewen.dongbaoums.ums.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UmsMemberServiceImplTest {

    @Autowired
    private UmsMemberService umsMemberService;

    @Test
    void selectByPrimaryKey() {
        umsMemberService.selectByPrimaryKey(1L);
    }

    @Test
    void insert() {
        UmsMember umsMember = new UmsMember();
        umsMember.setEmail("hexuewen2008@126.com");
        umsMember.setCreateTime(new Date());
        umsMember.setLoginTime(new Date());
        umsMember.setNickName("xuewen");
        umsMember.setUsername("hexuewen1");

        umsMemberService.insert(umsMember);
    }
}