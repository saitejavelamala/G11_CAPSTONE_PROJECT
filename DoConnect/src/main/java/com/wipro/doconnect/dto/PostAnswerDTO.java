package com.wipro.doconnect.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*@Author:Gaurav Pal
 * Modified Date: 27-08-2022
 * Description:DTO classes
 * Parameters: Id,QuestionId,Answer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAnswerDTO
{
	@NotNull(message = "Please provide User ID")
	private Long userId;
	
	@NotNull(message = "Please provide Question ID")
	private Long questionId;
	
	@NotBlank(message = "Answer is needed to submit")
	private String answer;
}
