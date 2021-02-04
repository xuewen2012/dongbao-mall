package com.xuewen.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuewen.dongbao.common.base.result.ResultWrapper;
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
    ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    /**
     * 登录
     * @param umsMemberLoginParamDTO
     * @return
     */
    ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    /**
     * 修改
     * @param umsMember
     * @return
     */
    ResultWrapper edit(UmsMember umsMember);
}
