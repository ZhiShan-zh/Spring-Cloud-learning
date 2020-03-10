package com.zh.redisspringboot.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private Long id;
	private String name;
	private Long score;
	private Date birthday;
	public Student() {
		super();
	}
	public Student(Long id, String name, Long score, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.birthday = birthday;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
