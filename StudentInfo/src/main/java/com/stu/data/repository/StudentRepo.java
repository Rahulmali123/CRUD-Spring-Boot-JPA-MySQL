package com.stu.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stu.data.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

}



