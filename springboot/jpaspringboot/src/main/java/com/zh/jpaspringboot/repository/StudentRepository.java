package com.zh.jpaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zh.jpaspringboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
