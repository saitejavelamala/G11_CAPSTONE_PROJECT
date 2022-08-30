package com.wipro.doconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@Author:Gaurav Pal
 * Modified Date: 27-08-2022
 * Description:Question Entity
 * Parameters: Id,Question,User,Topic
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Question can not be blank")
	private String question;
	
	@OneToOne
	private User user;
	
	@NotBlank(message = "provide the topic")
	private String topic;
	
	private Boolean isApproved = false;
}
