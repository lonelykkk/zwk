/**
 * 慧程框架
 */

package com.kkk.exception.base;

public class BaseKnownException extends RuntimeException implements BaseErrorCode {
    private Integer code;
    private String message;
    private Object[] args;

    public BaseKnownException() {
        this(10000, "报错信息未设置");
    }

    public BaseKnownException(BaseErrorCode errorCode, Object... args) {
        this(errorCode.getCode(), errorCode.getMessage(), args);
    }

    public BaseKnownException(String errorMessage, Object... args) {
        this(10000, errorMessage, args);
    }

    public BaseKnownException(Integer errorCode, String errorMessage, Object... args) {
        this.code = errorCode;
        this.message = errorMessage;
        if (args != null && args.length > 0) {
            this.args = args;
        }

    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object[] getArgs() {
        return this.args;
    }
}
