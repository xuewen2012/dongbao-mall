package com.xuewen.dongbao.common.base.result;

import com.xuewen.dongbao.common.base.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @author: hexuewen
 * @date: 2021/1/25
 */
@Builder
@Data
public class ResultWrapper<T> implements Serializable {

    //状态码
    private int code;

    //提示信息
    private String msg;

    private T data;

    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder() {
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }

    public static ResultWrapper.ResultWrapperBuilder getFailBuilder() {
        return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
    }
}
