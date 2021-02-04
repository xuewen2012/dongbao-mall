package com.xuewen.dongbao.portal.web.advice;

import com.xuewen.dongbao.common.base.exception.TokenException;
import com.xuewen.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException() {
        return ResultWrapper.builder().code(301).msg("数学运算异常").build();
    }

    @ExceptionHandler(TokenException.class)
    public ResultWrapper loginException(Exception e) {
        return ResultWrapper.getFailBuilder().msg(e.getMessage()).build();
    }
}
