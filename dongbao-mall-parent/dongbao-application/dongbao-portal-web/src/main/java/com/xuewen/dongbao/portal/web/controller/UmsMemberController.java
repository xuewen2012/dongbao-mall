package com.xuewen.dongbao.portal.web.controller;


import com.xuewen.dongbao.common.base.annotation.TokenCheck;
import com.xuewen.dongbao.common.base.result.ResultWrapper;
import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public ResultWrapper register(@RequestBody @Validated UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @GetMapping("/login")
    public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @PostMapping("/edit")
    @TokenCheck
    public ResultWrapper edit(@RequestBody UmsMember umsMember) {
        return umsMemberService.edit(umsMember);
    }

}

