package com.zh.limit.exception;

import org.springframework.http.HttpStatus;

/**
 * @Author: ZhangHai
 * @Date: 2021/2/4 17:18
 */
public class BadRequestException extends RuntimeException{
    private Integer status = HttpStatus.BAD_REQUEST.value();
    public BadRequestException(String msg){
        super(msg);
    }
    public BadRequestException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }

    public Integer getStatus() {
        return status;
    }
}
