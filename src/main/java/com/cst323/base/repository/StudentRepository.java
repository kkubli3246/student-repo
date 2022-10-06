package com.cst323.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst323.base.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	
}

