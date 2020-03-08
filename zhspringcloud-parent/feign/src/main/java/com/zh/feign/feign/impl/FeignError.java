package com.zh.feign.feign.impl;

import java.util.Collection;
import org.springframework.stereotype.Component;

import com.zh.feign.entity.Student;
import com.zh.feign.feign.FeignProviderClient;

@Component
public class FeignError implements FeignProviderClient{

	@Override
	public Collection<Student> findAll() {
		return null;
	}

	@Override
	public String index() {
		return "服务器维护中......";
	}

}
