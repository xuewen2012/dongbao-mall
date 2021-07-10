package com.xuewen.dongbao.portal.web.advice;

import com.xuewen.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {


    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException() {
        return ResultWrapper.builder().code(301).msg("数学运算错误").build();
    }

    @ExceptionHandler(Exception.class)
    public ResultWrapper customException1() {
        return ResultWrapper.builder().code(301).msg("统一错误").build();
    }
}
