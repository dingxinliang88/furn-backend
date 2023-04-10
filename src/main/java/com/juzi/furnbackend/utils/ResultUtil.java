package com.juzi.furnbackend.utils;


import com.juzi.furnbackend.common.BaseResponse;
import com.juzi.furnbackend.common.ErrorCode;

/**
 * 返回结果工具类
 *
 * @author codejuzi
 * @CreateTime 2023/4/5
 */
public class ResultUtil {

    /**
     * 成功
     *
     * @param data 成功后的响应结果
     * @param <T>  泛型
     * @return BasesResponse
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), data, "");
    }

    /**
     * 失败
     *
     * @param code code
     * @param message message
     * @param description desc
     * @return BasesResponse
     */
    public static BaseResponse<?> error(int code, String message, String description) {
        return new BaseResponse<>(code, null, message, description);
    }

    /**
     * 失败
     *
     * @param errorCode error code
     * @param message message
     * @param description desc
     * @return BasesResponse
     */
    public static BaseResponse<?> error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse<>(errorCode.getCode(), null, message, description);
    }

}
