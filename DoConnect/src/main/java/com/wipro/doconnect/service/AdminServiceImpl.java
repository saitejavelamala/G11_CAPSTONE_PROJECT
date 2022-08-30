package com.wipro.doconnect.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.doconnect.dto.ResponseDTO;
import com.wipro.doconnect.entity.Admin;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exception.QuestionAlreadyThere;
import com.wipro.doconnect.exception.AnswerNotFound;
import com.wipro.doconnect.repository.AdminRepository;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;
import com.wipro.doconnect.service.AdminService;
/*@Author:Saiteja Velamala
 * Modified Date: 28-08-2022
 * Description:Admin Service Implementation
 */

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	/*@Author:Saiteja Velamala
	 * Modified Date: 28-08-2022
	  */
	public Admin adminLogin(String email, String password)
	{
		Admin admin = adminRepository.findByEmail(email);
		if (Objects.isNull(admin))
			throw new AnswerNotFound();

		if (admin.getPassword().equals(password))
		{
			admin.setIsActive(true);
			adminRepository.save(admin);
		}
		else
			throw new AnswerNotFound();
		return admin;
	}

	@Override
	/*@Author:Saumya Raj
	 * Modified Date: 28-08-2022
	  */
	public String adminLogout(Long adminId)
	{
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AnswerNotFound("Admin not found"));
		admin.setIsActive(false);
		adminRepository.save(admin);
		return "Logged Out";
	}

	@Override
	/*@Author:Gaurav Pal
	 * Modified Date: 28-08-2022
	  */
	public Admin adminRegister(Admin admin)
	{
		Admin admin1 = adminRepository.findByEmail(admin.getEmail());
		if (Objects.isNull(admin1))
			return adminRepository.save(admin);

		throw new QuestionAlreadyThere();
	}

	@Override
	public User getUser(String email)
	{
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}

	@Override
	public List<Question> getUnApprovedQuestions()
	{
		return questionRepository.findByIsApproved();
	}

	@Override
	public List<Answer> getUnApprovedAnswers()
	{
		return answerRepository.findByIsApproved();
	}

	@Override
	public Question approveQuestion(Long questionId)
	{
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new AnswerNotFound("Question not found"));

		question.setIsApproved(true);
		question = questionRepository.save(question);
		return question;
	}

	@Override
	public Answer approveAnswer(Long answerId)
	{
		Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new AnswerNotFound("Answer not found"));

		answer.setIsApproved(true);
		answer = answerRepository.save(answer);
		return answer;
	}

	@Override
	public ResponseDTO deleteQuestion(Long questionId)
	{
		ResponseDTO responseDTO = new ResponseDTO();
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new AnswerNotFound("Question not found"));

		questionRepository.delete(question);
		responseDTO.setMsg("Question removed");
		return responseDTO;
	}

	@Override
	public ResponseDTO deleteAnswer(Long answerId)
	{
		ResponseDTO responseDTO = new ResponseDTO();

		Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new AnswerNotFound("Answer not found"));

		answerRepository.delete(answer);
		responseDTO.setMsg("Answer Removed");
		return responseDTO;
	}
}
