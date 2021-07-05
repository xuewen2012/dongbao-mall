package com.xuewen.dongbao.portal.web.controller;

import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

	@GetMapping("/register")
	public String register() {
		UmsMember umsMember = new UmsMember();
		umsMember.setEmail("hexuewen2008@126.com");
		umsMember.setNickName("xuewen");
		umsMember.setUsername("hexuewen4");

		umsMemberService.insert(umsMember);

		return "success";
	}

}