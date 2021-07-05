package com.xuewen.dongbao.ums.mapper;

import com.xuewen.dongbao.ums.entity.UmsMember;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);
}