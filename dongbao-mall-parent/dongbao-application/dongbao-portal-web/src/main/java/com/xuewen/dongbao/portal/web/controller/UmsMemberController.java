package com.xuewen.dongbao.portal.web.controller;


import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author hexuewen
 * @since 2021-01-23
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/register")
    public String register(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        umsMemberService.register(umsMemberRegisterParamDTO);
        return "success";
    }

    @GetMapping("/login")
    public String login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

}

