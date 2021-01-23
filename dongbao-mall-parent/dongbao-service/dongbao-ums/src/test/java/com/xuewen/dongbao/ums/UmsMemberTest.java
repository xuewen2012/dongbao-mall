package com.xuewen.dongbao.ums;

import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/23
 */
@SpringBootTest
public class UmsMemberTest {

    @Autowired
    private UmsMemberService umsMemberService;

    @Test
    public void save() {
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("hexuewen111");

        umsMemberService.save(umsMember);
    }
}
