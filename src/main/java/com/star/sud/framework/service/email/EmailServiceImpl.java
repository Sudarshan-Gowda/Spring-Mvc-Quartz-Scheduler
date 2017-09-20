package com.star.sud.framework.service.email;
/*created by Sudarshan on 19-09-17*/
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("starEmailService")
public class EmailServiceImpl implements EmailService {

	@Resource(name = "starMailSender")
	protected JavaMailSender mailSender;

	@Override
	public void sendMail(EmailInfo emailInfo) {

		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
		try {
			message.setSubject(emailInfo.getSubject());
			message.setFrom(emailInfo.getFromAddress());
			message.setTo(emailInfo.getEmailTo());
			// message.setCc(emailInfo.getEmailCc());
			message.setText(emailInfo.getMessageBody(), true);
			this.mailSender.send(mimeMessage);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
