package com.zh.mongodbspringboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "my_student")
public class Student {
	@Id
	private String id;
	@Field(value = "student_age")
	private Integer age;
	@Field(value = "student_name")
	private String name;
	public Student() {
		super();
	}
	public Student(String id, Integer age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
