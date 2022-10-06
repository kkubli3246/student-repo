package com.cst323.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst323.base.domain.Student;
import com.cst323.base.repository.StudentRepository;

@Service
public class StudentService {
		
		@Autowired
		private StudentRepository repo;
		
		public List<Student> listAll(){
			return repo.findAll();
		}
		public void save(Student stu) {
			repo.save(stu);
		}
		public Student get(long id) {
			return repo.findById(id).get();
		}
		
		public void delete(long id) {
			repo.deleteById(id);
		}
	
	
}
