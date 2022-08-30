package com.wipro.doconnect.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/*@Author:Jaswanth dammalapati
 * Modified Date: 27-08-2022
 * Description:Answer not found exception
 */
@NoArgsConstructor
@AllArgsConstructor
public class AnswerNotFound extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String errorMsg;

}
