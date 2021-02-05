package com.zh.limit.controller;

import com.zh.limit.annotation.Limit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ZhangHai
 * @Date: 2021/2/1 16:50
 */
@Controller
public class LimitTestController {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    @GetMapping("/testLimit")
    @ResponseBody
    @Limit(key = "test", period = 60, count = 10, name = "testLimit", prefix = "limit")
    public int testLimit(){
        return ATOMIC_INTEGER.incrementAndGet();
    }
}
