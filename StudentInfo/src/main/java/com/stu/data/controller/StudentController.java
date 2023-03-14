package com.stu.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stu.data.dto.ApiResponse;
import com.stu.data.dto.StudentDto;
import com.stu.data.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/CreateStudent/")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto)
	{
		StudentDto createUser = this.studentService.createStudent(studentDto);
		return new ResponseEntity<StudentDto>(createUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/UpdateStudentData/{id}")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto,@PathVariable("id") Integer id)
	{
		StudentDto updateUser = this.studentService.updateStudent(studentDto, id);
		return new ResponseEntity<StudentDto>(updateUser, HttpStatus.OK);
	}
	
	@GetMapping("/getBySingleStudentId/{id}")
	public ResponseEntity<StudentDto> getStudentId(@PathVariable("id") Integer id)
	{
		StudentDto studentDto = this.studentService.getStudent(id);
		return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
		
	}

	
	@DeleteMapping("/delateuser/{id}")
	public ResponseEntity<ApiResponse> deleteByStudentId(@PathVariable("id") Integer id)
	{
		 this.studentService.deleteStudent(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("data delete successfully", false), HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllStudents/")
	public ResponseEntity<List<StudentDto>> getAllStudent()
	{
		List<StudentDto> allStudents = this.studentService.getAllStudents();
		
		return new ResponseEntity<List<StudentDto>>(allStudents, HttpStatus.OK);
	}
	
}