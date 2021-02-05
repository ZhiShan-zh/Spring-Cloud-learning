package com.zh.limit.annotation;

import com.zh.limit.exception.BadRequestException;
import com.zh.limit.utils.ExpireHashMap;
import com.zh.limit.utils.RequestUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 限流通知类
 * @Author: ZhangHai
 * @Date: 2021/2/1 17:05
 */
@Aspect
@Component
public class LimitAdvice {
    private final ExpireHashMap<String, Integer> expireHashMap = new ExpireHashMap();

    @Pointcut("@annotation(com.zh.limit.annotation.Limit)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request = RequestUtil.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Limit limit = method.getAnnotation(Limit.class);
        LimitType limitType = limit.limitType();
        String key = limit.key();
        if(StringUtils.isEmpty(key)){
            if(limitType == LimitType.IP){
                key = RequestUtil.getIp(request);
            }else {
                key = method.getName();
            }
        }
        String map_key = limit.period() + "_" + key + "_" + request.getRequestURI().replaceAll("/", "_");
        Integer count = null;
        synchronized (this){
            count = this.expireHashMap.get(map_key);
            long expire = count == null? limit.period()*1000:this.expireHashMap.expire(map_key);
            count = count == null?1:++count;
            this.expireHashMap.put(map_key, count, expire);
        }
        if(null != count && count <= limit.count()){
            System.out.println("访问次数为：" + count);
            return joinPoint.proceed();
        }else{
            throw new BadRequestException("访问次数受限");
        }
    }
}
