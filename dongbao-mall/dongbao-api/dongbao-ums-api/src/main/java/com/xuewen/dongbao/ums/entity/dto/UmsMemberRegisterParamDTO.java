package com.xuewen.dongbao.ums.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UmsMemberRegisterParamDTO {

    @NotEmpty
    @Size(min = 1, max = 8, message="用户名长度必须在1~8之间")
    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;
}
