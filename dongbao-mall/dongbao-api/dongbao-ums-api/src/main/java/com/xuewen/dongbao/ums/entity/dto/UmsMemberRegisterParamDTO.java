package com.xuewen.dongbao.ums.entity.dto;

import lombok.Data;

@Data
public class UmsMemberRegisterParamDTO {
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
