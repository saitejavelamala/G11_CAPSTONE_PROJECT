package com.wipro.doconnect.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.doconnect.dto.AskQuestionDTO;
import com.wipro.doconnect.dto.Message;
import com.wipro.doconnect.dto.PostAnswerDTO;
import com.wipro.doconnect.entity.Admin;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.ImageModel;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exception.QuestionAlreadyThere;
import com.wipro.doconnect.exception.AnswerNotFound;
import com.wipro.doconnect.repository.AdminRepository;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.ImageModelRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;
import com.wipro.doconnect.service.EmailSenderService;
import com.wipro.doconnect.service.UserService;
/*@Author:Arpit Verma
 * Modified Date: 28-08-2022
 * Description:User Service Implementation
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private ImageModelRepository imageModelRepo;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	 /*@Author:Arpit Verma
		 * Modified Date: 28-08-2022
		  */
	public User userLogin(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (Objects.isNull(user))
			throw new AnswerNotFound();

		if (user.getPassword().equals(password)) {
			user.setIsActive(true);
			userRepo.save(user);
		} else
			throw new AnswerNotFound();
		return user;
	}

	@Override
	/*@Author:Saiteja Velamala
	 * Modified Date: 28-08-2022
	  */
	public String userLogout(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new AnswerNotFound("User Not Found" + userId));
		user.setIsActive(false);
		userRepo.save(user);
		return "Logged Out";
	}

	@Override
	/*@Author:Gaurav Pal
	 * Modified Date: 28-08-2022
	  */
	public User userRegister(User user) {
		User user1 = userRepo.findByEmail(user.getEmail());
		if (Objects.isNull(user1))
			return userRepo.save(user);
		throw new QuestionAlreadyThere();
	}

	@Override
	public Question askQuestion(AskQuestionDTO askQuestionDTO) {
		Question question = new Question();
		User user = userRepo.findById(askQuestionDTO.getUserId()).orElseThrow(() -> new AnswerNotFound("User Not Found"));
		question.setQuestion(askQuestionDTO.getQuestion());
		question.setTopic(askQuestionDTO.getTopic());
		question.setUser(user);
		questionRepo.save(question);
		List<Admin> admins = adminRepository.findAll();
		for (Admin admin : admins)
		{
			sendMail(admin.getEmail(), "Question Added by "+user.getName());
		}
		return question;
	}

	@Override
	public Answer giveAnswer(@Valid PostAnswerDTO postAnswerDTO) {
		Answer answer = new Answer();
		User answerUser = userRepo.findById(postAnswerDTO.getUserId())
				.orElseThrow(() -> new AnswerNotFound("User Not Found"));

		Question question = questionRepo.findById(postAnswerDTO.getQuestionId())
				.orElseThrow(() -> new AnswerNotFound("Question Not Found"));
		answer.setQuestion(question);
		answer.setAnswer(postAnswerDTO.getAnswer());
		answer.setAnswerUser(answerUser);

		answerRepo.save(answer);
		
		List<Admin> admins = adminRepository.findAll();
		for (Admin admin : admins)
		{
			sendMail(admin.getEmail(), "Answer Added by "+answerUser.getName());
		}
		
		return answer;
	}

	@Override
	public List<Answer> getAnswers(Long questionId) {
		return answerRepo.findByQuestionId(questionId);
	}

	@Override
	public List<Question> getQuestions(String topic) {
		if (topic.equalsIgnoreCase("All")) {
			return questionRepo.findByIsApprovedTrue();
		}
		return questionRepo.findByTopicAndApproved(topic);
	}

	@Override
	public List<Question> searchQuestion(String question) {
		String sqlQuery = "from Question where (question like :question) and isApproved = 1";
		return entityManager.createQuery(sqlQuery, Question.class).setParameter("question", "%" + question + "%")
				.getResultList();
	}

	@Override
	public BodyBuilder uplaodImage(MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		imageModelRepo.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}

	@Override
	public ImageModel getImage(String imageName) {
		final Optional<ImageModel> retrievedImage = imageModelRepo.findByName(imageName);
		if(retrievedImage.isPresent())
		{
			ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(), decompressBytes(retrievedImage.get().getPicByte()));
			return img;
		}
		return null;
	}

	@Override
	public Message sendMessage(@Valid Message message) {
		String url = "http://localhost:9595/chat/sendMessage";
		ResponseEntity<Message> responseEntity = restTemplate.postForEntity(url, message, Message.class);
		Message response = responseEntity.getBody();

		return response;
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	public Boolean sendMail(String emailId, String type)
	{
		try
		{
			emailSenderService.sendEmail(emailId, type, type);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("error in sending mail " + e);
			return false;
		}
	}
}
