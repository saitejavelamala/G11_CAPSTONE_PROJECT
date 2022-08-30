package com.wipro.doconnect.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@Author:Saumya Raj
 * Modified Date: 27-08-2022
 * Description:DTO classes
 * Parameters: Id,QuestionId,Topic
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AskQuestionDTO
{
	@NotNull(message = "Please Provide the ID")
	private Long userId;
	
	@NotBlank(message = "Question required")
	private String question;
	
	@NotBlank(message = "Please provide the topic")
	private String topic;

}
