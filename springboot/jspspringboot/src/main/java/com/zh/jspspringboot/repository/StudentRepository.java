package com.zh.jspspringboot.repository;

import java.util.Collection;

import com.zh.jspspringboot.entity.Student;

public interface StudentRepository {
	public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
