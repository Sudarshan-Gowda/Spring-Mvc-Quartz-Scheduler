package com.star.sud.framework.service.email;

/*created by Sudarshan on 19-09-17*/
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.star.sud.framework.service.email.EmailStatus.STATUS;

@Service("starEmailService")
public class EmailServiceImpl implements EmailService {

	@Resource(name = "starMailSender")
	protected JavaMailSender mailSender;

	@Override
	public EmailStatus sendMail(EmailInfo emailInfo) {
		EmailStatus status = new EmailStatus();

		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
		try {
			message.setSubject(emailInfo.getSubject());
			message.setFrom(emailInfo.getFromAddress());
			message.setTo(emailInfo.getEmailTo());
			// message.setCc(emailInfo.getEmailCc());
			message.setText(emailInfo.getMessageBody(), true);
			this.mailSender.send(mimeMessage);
			status.setStatus(STATUS.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			status.setMessage(e.getMessage());
			status.setStatus(STATUS.FAILED);
		}
		return status;

	}

}
