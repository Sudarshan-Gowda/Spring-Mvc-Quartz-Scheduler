package com.star.sud.framework.service.email;
/*created by Sudarshan on 19-09-17*/
import java.io.Serializable;

public class EmailInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String emailType;
	protected String emailTemplate;
	protected String subject;
	protected String fromAddress;
	protected String messageBody;
	protected String encoding;
	protected String sendEmailReliableAsync;
	protected String sendAsyncPriority;
	protected String emailTo;
	protected String emailCc;

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getEmailTemplate() {
		return emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getSendEmailReliableAsync() {
		return sendEmailReliableAsync;
	}

	public void setSendEmailReliableAsync(String sendEmailReliableAsync) {
		this.sendEmailReliableAsync = sendEmailReliableAsync;
	}

	public String getSendAsyncPriority() {
		return sendAsyncPriority;
	}

	public void setSendAsyncPriority(String sendAsyncPriority) {
		this.sendAsyncPriority = sendAsyncPriority;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailCc() {
		return emailCc;
	}

	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}

}
