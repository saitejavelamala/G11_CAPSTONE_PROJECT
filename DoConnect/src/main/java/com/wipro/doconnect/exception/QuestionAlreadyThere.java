package com.wipro.doconnect.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/*@Author:Arpit Verma
 * Modified Date: 27-08-2022
 * Description:QuestionAlreadyThere exception
 */
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAlreadyThere extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String errorMsg;

}
