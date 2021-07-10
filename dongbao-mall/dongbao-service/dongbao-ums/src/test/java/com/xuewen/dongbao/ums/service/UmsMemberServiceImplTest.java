package com.xuewen.dongbao.ums.service;

import com.xuewen.dongbao.common.base.result.ResultWrapper;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = com.xuewen.dongbao.DongbaoUmsApplication.class)
class UmsMemberServiceImplTest {
    @Autowired
    private UmsMemberService umsMemberService;

    @Test
    void login() {
        UmsMemberLoginParamDTO umsMemberLoginParamDTO = new UmsMemberLoginParamDTO();
        umsMemberLoginParamDTO.setPassword("1234");
        umsMemberLoginParamDTO.setUsername("hexuewen");
        ResultWrapper login = umsMemberService.login(umsMemberLoginParamDTO);
    }
}