package com.zh.redisspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zh.redisspringboot.entity.Student;

@RestController
public class StudentHandler {
	
	@Autowired
	private RedisTemplate redisTemplate;
	@PostMapping("/set")
	public void set(@RequestBody Student student) {
		redisTemplate.opsForValue().set("stu", student);
	}
	@GetMapping("/get/{key}")
	public Student get(@PathVariable("key") String key) {
		return (Student)redisTemplate.opsForValue().get(key);
	}
	
	@GetMapping("/delete/{key}")
	public boolean delete(@PathVariable("key") String key) {
		redisTemplate.delete(key);
		return redisTemplate.hasKey(key);
	}
}
