package com.stu.data.service;

import java.util.List;

import com.stu.data.dto.StudentDto;

public interface StudentService
{
	StudentDto createStudent(StudentDto studentDto);
	
	StudentDto updateStudent(StudentDto studentDto,Integer id);
	
	StudentDto getStudent(Integer id);
	
	void deleteStudent(Integer id);

	List<StudentDto> getAllStudents();
	
	
}