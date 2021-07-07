package com.xuewen.dongbao.portal.web.controller;

import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
	public String register(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
		umsMemberService.register(umsMemberRegisterParamDTO);
		return "success";
	}

	@PostMapping("/login")
	public String login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
		return umsMemberService.login(umsMemberLoginParamDTO);
	}

}