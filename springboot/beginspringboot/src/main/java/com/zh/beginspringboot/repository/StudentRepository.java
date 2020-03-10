package com.zh.beginspringboot.repository;

import java.util.Collection;

import com.zh.beginspringboot.entity.Student;

public interface StudentRepository {
	public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
