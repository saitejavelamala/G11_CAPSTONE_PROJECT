package com.wipro.doconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@Author:Arpit Verma
 * Modified Date: 27-08-2022
 * Description:User Entity
 * Parameters: Id,Name,password,email,mobile number
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_name")
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Column(name = "user_password")
	@NotBlank(message = "Password is mandatory")
	@Size(min = 8)
	private String password;
	
	@Column(name = "user_email")
	@NotBlank(message = "email is mandatory")
	@Email(message = "Enter a valid mail only")
	private String email;
	
	@Column(name = "user_phone_number")
	@NotBlank(message = "phone number is mandatory")
	@Size(max = 10, min = 10)
	private String phoneNumber;

	@Column(name = "is_email_active")
	private Boolean isActive = true;
}