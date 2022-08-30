package com.wipro.doconnect.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.service.EmailSenderService;
/*@Author:Jaswanth dammalapati
 * Modified Date: 28-08-2022
 * Description:Email Sender Service Implementation
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
	
    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    /*@Author:Arpit Verma
	 * Modified Date: 28-08-2022
	  */
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("$(DoConnect.org)");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
    }
}
