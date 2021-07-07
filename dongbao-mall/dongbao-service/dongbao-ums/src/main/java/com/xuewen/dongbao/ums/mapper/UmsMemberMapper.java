package com.xuewen.dongbao.ums.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

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

    List<UmsMember> findByUsername(@Param("username")String username);


}