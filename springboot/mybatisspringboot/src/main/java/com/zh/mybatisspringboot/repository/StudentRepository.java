package com.zh.mybatisspringboot.repository;

import java.util.List;

import com.zh.mybatisspringboot.entity.Student;

public interface StudentRepository {
	public List<Student> findAll();
	public Student findById(Long id);
	public void save(Student student);
	public void update(Student student);
	public void deleteById(Long id);
}
