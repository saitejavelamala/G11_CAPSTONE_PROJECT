package com.wipro.doconnect.service;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.doconnect.dto.AskQuestionDTO;
import com.wipro.doconnect.dto.Message;
import com.wipro.doconnect.dto.PostAnswerDTO;
import com.wipro.doconnect.dto.ResponseDTO;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.ImageModel;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
/*@Author:Arpit Verma
 * Modified Date: 27-08-2022
 * Description:User Service
 */
public interface UserService
{
	public User userLogin(String email, String password);
	public String userLogout(Long userId);
	public User userRegister(@Valid User user);
	
	public Question askQuestion(@Valid AskQuestionDTO askQuestionDTO);
	public Answer giveAnswer(@Valid PostAnswerDTO postAnswerDTO);
	
	
	public List<Question> searchQuestion(String question);
	
	public List<Answer> getAnswers(Long questionId);
	public List<Question> getQuestions(String topic);
	
	public BodyBuilder uplaodImage(MultipartFile file) throws IOException;
	public ImageModel getImage(String imageName);
	
	public Message sendMessage(@Valid Message message);
}
