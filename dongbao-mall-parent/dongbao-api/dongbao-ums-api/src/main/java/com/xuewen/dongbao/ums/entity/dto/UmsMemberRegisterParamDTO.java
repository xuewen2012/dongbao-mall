package com.xuewen.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/25
 */
@ToString
@Data
public class UmsMemberRegisterParamDTO {

    @Size(min=1, max=8, message="用户名长度在1-8之间")
    private String username;

    @NotBlank
    private String password;

    private String icon;

    private String email;

    private String nickName;
}
