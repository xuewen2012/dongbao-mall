package com.xuewen.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/25
 */
@ToString
@Data
public class UmsMemberRegisterParamDTO {

    private String username;

    private String password;

    private String icon;

    private String email;

    private String nickName;
}
