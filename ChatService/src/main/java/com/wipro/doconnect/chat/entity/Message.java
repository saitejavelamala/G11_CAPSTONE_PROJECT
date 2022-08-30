package com.wipro.doconnect.chat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@Author:Jaswanth dammalapati
 * Modified Date: 29-08-2022
 * Description:Message Entity
 * Parameters: Id,message,name
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "To which user u want to send")
	private String message;
	
	private String fromUser;
}
