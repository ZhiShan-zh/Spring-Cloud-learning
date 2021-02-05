package com.zh.limit.annotation;

/**
 * 限流类型枚举类
 * @Author: ZhangHai
 * @Date: 2021/2/1 17:00
 */
public enum LimitType {
    CUSTOMER,//默认值，用户自定义限流类型
    IP//ip限流类型
}
