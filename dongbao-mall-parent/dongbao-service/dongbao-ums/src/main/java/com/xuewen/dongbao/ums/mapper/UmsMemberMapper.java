package com.xuewen.dongbao.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuewen.dongbao.ums.entity.UmsMember;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author hexuewen
 * @since 2021-01-23
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    UmsMember selectByName(String username);
}
