package com.stu.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stu.data.entities.Student;
import com.stu.data.repository.StudentRepo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentInfoApplicationTests 
{
	@Autowired
	StudentRepo  studentRepo;

	@Test
	@Order(1)
	void testcreate()
	{
		Student s=new Student();
		s.setId(1);
		s.setFirst_name("sagar");
		s.setLast_name("mali");
		s.setEmail("sagarmali2140@gmail.com");
		s.setAge(35);
		
		studentRepo.save(s);
		
		assertNotNull(studentRepo.findById(1).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll()
	{
		List<Student> list=studentRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void testSingleStudent()
	{
		Student student= studentRepo.findById(1).get();
		assertEquals(41, student.getAge());
	}
	
	@Test
	@Order(3)
	public void testUpdate()
	{
		Student student = studentRepo.findById(1).get();
		student.setAge(41);
		studentRepo.save(student);
		assertNotEquals(35,studentRepo.findById(1).get().getAge());
	}
	@Test
	@Order(5)
	public  void testdelete()
	{
		studentRepo.deleteById(2);
		assertThat(studentRepo.existsById(2)).isFalse();
		
	}
}
