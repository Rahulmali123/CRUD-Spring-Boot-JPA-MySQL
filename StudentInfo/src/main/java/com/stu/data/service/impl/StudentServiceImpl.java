package com.stu.data.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.data.dto.StudentDto;
import com.stu.data.entities.Student;
import com.stu.data.exception.ResourceNotFoundException;
import com.stu.data.repository.StudentRepo;
import com.stu.data.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService
{
	
	@Autowired
	private StudentRepo studentRepo; 
	
	@Autowired
	private ModelMapper modeMapper;
	
	public Student dtoToStudent(StudentDto studentDto)
	{
		Student student = this.modeMapper.map(studentDto,Student.class);
		return student;
	}
	
	public StudentDto StudentToDto(Student student)
	{
		 StudentDto studentDto = this.modeMapper.map(student, StudentDto.class);
		return studentDto;
	}

	@Override
	public StudentDto createStudent(StudentDto studentDto)
	{
		Student student=this.dtoToStudent(studentDto);
		
		Student addstudent=this.studentRepo.save(student);
		return this.StudentToDto(addstudent);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer id) 
	{
		Student student=this.studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","id", id));
		
		student.setFirst_name(studentDto.getFirst_name());
		student.setLast_name(studentDto.getLast_name());
		student.setEmail(studentDto.getEmail());
		student.setAge(studentDto.getAge());
		
		Student updateStudent = this.studentRepo.save(student);
		
		StudentDto studentToDto = this.StudentToDto(updateStudent);
		return studentToDto;
	}

	@Override
	public StudentDto getStudent(Integer id) 
	{
		Student student=this.studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","id", id));
		
		return this.StudentToDto(student);
	}

	@Override
	public void deleteStudent(Integer id) 
	{
		Student student=this.studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","id", id));
		
		this.studentRepo.delete(student);
		
	}

	@Override
	public List<StudentDto> getAllStudents() 
	{
		List<Student> students = this.studentRepo.findAll();
		
		List<StudentDto> listofStudent = students.stream().map(stu->this.StudentToDto(stu)).collect(Collectors.toList());
		return listofStudent;
	}


}
