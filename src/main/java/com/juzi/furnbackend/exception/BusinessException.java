package com.juzi.furnbackend.exception;


import com.juzi.furnbackend.common.ErrorCode;

/**
 * 业务异常类
 *
 * @author codejuzi
 * @CreateTime 2023/4/5
 */
public class BusinessException extends RuntimeException {

    /**
     * 状态码
     */
    private final int code;

    /**
     * 异常的详细信息
     */
    private final String description;

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
