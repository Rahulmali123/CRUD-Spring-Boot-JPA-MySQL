package com.stu.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StudentDto 
{
	
	private int id;
	
	@NotBlank
	@Size(min = 3,max = 10,message = "min char size is 3 & max size is 10")
	private String first_name;
	
	@NotBlank
	@Size(min = 3,max = 10,message = "min char size is 3 & max size is 10")
	private String last_name;
	
	@NotBlank
	@Email
	private String email;
	
	private int age;

}
