package com.xuewen.dongbao.portal.web.AuthInterceptor;

import com.xuewen.dongbao.common.base.annotations.TokenCheck;
import com.xuewen.dongbao.common.base.exception.TokenException;
import com.xuewen.dongbao.common.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器进入");
        String token = request.getHeader("token");
        /*if (StringUtils.isBlank(token)) {
            throw new TokenException("token 为空");
        }*/
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(TokenCheck.class)) {
                TokenCheck annotation = method.getAnnotation(TokenCheck.class);
                if(annotation.required()) {
                    try {
                        JwtUtil.parseToken(token);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
