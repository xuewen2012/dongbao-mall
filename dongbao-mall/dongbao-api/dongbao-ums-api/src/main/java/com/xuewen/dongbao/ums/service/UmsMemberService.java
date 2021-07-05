package com.xuewen.dongbao.ums.service;

import com.xuewen.dongbao.ums.entity.UmsMember;

public interface UmsMemberService{


    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);

}
