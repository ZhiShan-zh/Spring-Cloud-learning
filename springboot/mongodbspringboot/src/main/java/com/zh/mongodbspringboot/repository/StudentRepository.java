package com.zh.mongodbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zh.mongodbspringboot.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
	public Student getById(String id);
}
