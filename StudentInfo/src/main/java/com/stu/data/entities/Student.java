package com.stu.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studentdetails")
@Getter
@Setter
@NoArgsConstructor
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "FirstName",nullable = false,length = 100)
	private String first_name;
	
	@Column(name = "LastName",nullable = false,length = 100)
	private String last_name;
	
	private String email;
	
	private int age;
	

}
