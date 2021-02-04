package com.xuewen.dongbao.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuewen.dongbao.common.base.annotation.TokenCheck;
import com.xuewen.dongbao.common.base.enums.StateCodeEnum;
import com.xuewen.dongbao.common.base.result.ResultWrapper;
import com.xuewen.dongbao.common.util.JwtUtil;
import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.xuewen.dongbao.ums.entity.response.UserMemberLoginResponse;
import com.xuewen.dongbao.ums.mapper.UmsMemberMapper;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author hexuewen
 * @since 2021-01-23
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        String encode = passwordEncoder.encode(umsMember.getPassword());
        umsMember.setPassword(encode);
        this.save(umsMember);
        return ResultWrapper.getSuccessBuilder().build();
    }

    @Override
    public ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if(null !=  umsMember){
            String passwordDb = umsMember.getPassword();

            if(!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(),passwordDb)){
                return ResultWrapper.getFailBuilder().code(StateCodeEnum.PASSWORD_ERROR.getCode())
                .msg(StateCodeEnum.PASSWORD_ERROR.getMsg()).build();
            }

        }else{
            return ResultWrapper.getFailBuilder().code(StateCodeEnum.USER_EMPTY.getCode())
                .msg(StateCodeEnum.USER_EMPTY.getMsg()).build();
        }

        String token = JwtUtil.createToken(umsMember.getUsername());

        UserMemberLoginResponse userMemberLoginResponse = new UserMemberLoginResponse();
        userMemberLoginResponse.setToken(token);
        umsMember.setPassword("");
        userMemberLoginResponse.setUmsMember(umsMember);

        System.out.println("登录成功");
        return ResultWrapper.getSuccessBuilder().data(userMemberLoginResponse).build();
    }

    @Override
    public ResultWrapper edit(UmsMember umsMember) {
        umsMemberMapper.updateById(umsMember);
        return ResultWrapper.getSuccessBuilder().data(umsMember).build();
    }
}
