package com.zh.shirospringboot.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSessionManager sessionManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //因为这里只有一个filter，所以设置map容量为1
        Map<String, Filter> filterMap = new HashMap<String, Filter>(1);
        shiroFilterFactoryBean.setFilters(filterMap);//这里是设置自定义过滤器的，也可以不设置，shiro已经内置了一些过滤器可以使用
        return shiroFilterFactoryBean;
    }
}
