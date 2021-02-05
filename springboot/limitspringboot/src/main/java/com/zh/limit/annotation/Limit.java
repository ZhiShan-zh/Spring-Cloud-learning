package com.zh.limit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ZhangHai
 * @Date: 2021/2/1 16:54
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
    String name() default "";//资源名称，用于描述接口的功能
    String key() default "";//资源的key，用于记录访问记录等信息
    String prefix() default ""; //key的前缀，可以是模块名，用于整合key
    int period();//限流次数的计算时间段, 单位为秒
    int count();//限制次数，为period周期内的限制次数
    LimitType limitType() default LimitType.CUSTOMER;//限流类型
}
