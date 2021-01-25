package com.xuewen.dongbao.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuewen.dongbao.ums.entity.UmsMember;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.xuewen.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.xuewen.dongbao.ums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuewen.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public void register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        String encode = passwordEncoder.encode(umsMember.getPassword());
        umsMember.setPassword(encode);
        this.save(umsMember);
    }

    @Override
    public String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if(null !=  umsMember){
            String passwordDb = umsMember.getPassword();

            if(!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(),passwordDb)){
                return "密码不正确";
            }

        }else{
            return "用户不存在";
        }

        System.out.println("登录成功");
        return "token";
    }
}
