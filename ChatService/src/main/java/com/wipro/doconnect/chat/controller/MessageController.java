package com.wipro.doconnect.chat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doconnect.chat.dto.MessageDTO;
import com.wipro.doconnect.chat.service.MessageService;
/*@Author:Jaswanth dammalapati
 * Modified Date: 29-08-2022
 * Description: Message controller
 */
@RestController
@RequestMapping("/chat")
@CrossOrigin
public class MessageController
{
	@Autowired
	private MessageService messageService;

	@PostMapping("/sendMessage")
	public MessageDTO sendMessage(@Valid @RequestBody MessageDTO messageDTO) {
		return messageService.sendMessage(messageDTO);
	}

	@GetMapping("/getMessage")
	public List<MessageDTO> getMessage() {
		return messageService.getMessage();
	}
}