package com.zh.securityspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//设置用户和角色的关系
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
			.withUser("user").password(new MyPasswordEncoder().encode("000")).roles("USER")
			.and()
			.withUser("admin").password(new MyPasswordEncoder().encode("123")).roles("ADMIN", "USER");
	}

	//设置角色和权限的关系
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/index").access("hasRole('ADMIN') or hasRole('USER')")
				.anyRequest().authenticated()	//上边的请求开启权限认证
				.and()
				.formLogin()
				.loginPage("/login")	//配置自定义的登录页面
				.permitAll()	//登录页面不需要权限认证
				.and()
				.logout().permitAll()	//退出连接不需要权限认证
				.and()
				.csrf().disable();	//禁用csrf
	}
}
