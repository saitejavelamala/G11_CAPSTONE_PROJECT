package com.wipro.doconnect.chat.service;

import java.util.List;
import javax.validation.Valid;
import com.wipro.doconnect.chat.dto.MessageDTO;
/*@Author:Saiteja Velamala
 * Modified Date: 29-08-2022
 * Description:Message Service
 */

public interface MessageService
{
	public MessageDTO sendMessage(@Valid MessageDTO messageDTO);
	public List<MessageDTO> getMessage();
}
