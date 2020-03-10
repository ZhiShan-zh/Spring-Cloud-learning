package com.zh.mybatisspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zh.mybatisspringboot.entity.Student;
import com.zh.mybatisspringboot.repository.StudentRepository;

@RestController
public class StudentHandler {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Student findById(@PathVariable("id") Long id) {
		return studentRepository.findById(id);
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Student student) {
		studentRepository.save(student);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Student student) {
		studentRepository.update(student);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		studentRepository.deleteById(id);
	}
}
