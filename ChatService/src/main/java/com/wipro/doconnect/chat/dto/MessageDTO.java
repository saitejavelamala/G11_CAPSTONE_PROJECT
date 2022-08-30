package com.wipro.doconnect.chat.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@Author:Saumya Raj
 * Modified Date: 29-08-2022
 * Description:DTO classes
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO
{
	@NotBlank(message = "provide the user Details")
	private String fromUser;

	@NotBlank(message = "provide message")
	private String message;
}
