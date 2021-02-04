package com.xuewen.dongbao.portal.web.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xuewen.dongbao.common.base.annotation.TokenCheck;
import com.xuewen.dongbao.common.base.exception.TokenException;
import com.xuewen.dongbao.common.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/2/4
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器进入");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)) {
            throw new TokenException("token 为空");
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        if(method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if(annotation.required()) {
                try {
                    JwtUtil.parseToken(token);
                    return true;
                } catch (Exception e) {
                    throw new TokenException("token 异常");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
