package com.wipro.doconnect.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.chat.dto.MessageDTO;
import com.wipro.doconnect.chat.entity.Message;
import com.wipro.doconnect.chat.repository.MessageRepository;
/*@Author:Arpit Verma
 * Modified Date: 29-08-2022
 * Description:Message Service Implementation
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;

	@Override
	
	public MessageDTO sendMessage(@Valid MessageDTO messageDTO) {
		Message message = new Message();
		message.setMessage(messageDTO.getMessage());
		message.setFromUser(messageDTO.getFromUser());
		message = messageRepository.save(message);

		messageDTO.setFromUser(message.getFromUser());
		messageDTO.setMessage(message.getMessage());

		return messageDTO;
	}
	
	@Override
	/*@Author:Saumya Raj
	 * Modified Date: 29-08-2022
	  */
	public List<MessageDTO> getMessage() {
		List<MessageDTO> data = new ArrayList<MessageDTO>();

		List<Message> messages = messageRepository.findAll();
		for (Message message : messages) {

			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setFromUser(message.getFromUser());
			messageDTO.setMessage(message.getMessage());
			data.add(messageDTO);

		}

		return data;
	}
}
