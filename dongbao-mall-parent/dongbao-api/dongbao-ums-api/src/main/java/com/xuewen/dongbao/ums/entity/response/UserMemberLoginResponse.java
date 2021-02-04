package com.xuewen.dongbao.ums.entity.response;

import com.xuewen.dongbao.ums.entity.UmsMember;
import lombok.Data;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/27
 */
@Data
public class UserMemberLoginResponse {
    private UmsMember umsMember;
    private String token;
}
