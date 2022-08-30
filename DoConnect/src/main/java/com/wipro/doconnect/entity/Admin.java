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
/*@Author:Jaswanth dammalapati
 * Modified Date: 27-08-2022
 * Description:Admin Entity
 * Parameters: Id,Name,password,email,mobile number
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin
{
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "admin_name")
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Column(name = "admin_password")
	@NotBlank(message = "password the mandatory")
	@Size(min = 8, message = "length should be 8")
	private String password;
	
	@Column(name = "admin_email")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "provide a valid mail id only")
	private String email;
	
	@Column(name = "admin_mobile_number")
	@NotBlank(message = "Phone Number is mandatory")
	@Size(max = 10, min = 10)
	private String phoneNumber;

	@Column(name = "is_email_active")
	private Boolean isActive = true;

}
