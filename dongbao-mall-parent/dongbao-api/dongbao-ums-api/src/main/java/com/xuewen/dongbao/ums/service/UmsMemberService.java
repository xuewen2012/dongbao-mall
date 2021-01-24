package com.xuewen.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author hexuewen
 * @since 2021-01-23
 */
public interface UmsMemberService extends IService<UmsMember> {

    /**
     * 注册demo
     */
    void register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    /**
     * 登录
     * @param umsMemberLoginParamDTO
     * @return
     */
    String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);
}
