package com.xuewen.dongbao.portal.web.controller;

import com.xuewen.dongbao.common.base.annotations.TokenCheck;
import com.xuewen.dongbao.common.base.result.ResultWrapper;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2020/12/29
 */
@RestController
@RequestMapping("/user-member")
public class UserMemberController {

	@Autowired
	UmsMemberService umsMemberService;

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@PostMapping("/register")
	public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
		umsMemberService.register(umsMemberRegisterParamDTO);
		return ResultWrapper.getSuccessBuilder().build();
	}

	@PostMapping("/login")
	public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
		return umsMemberService.login(umsMemberLoginParamDTO);
	}

	@GetMapping("/verify")
	@TokenCheck
	public ResultWrapper verify() {
		return ResultWrapper.getSuccessBuilder().data("s").build();
	}

}