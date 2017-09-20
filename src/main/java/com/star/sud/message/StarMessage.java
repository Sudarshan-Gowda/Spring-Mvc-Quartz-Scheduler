package com.star.sud.message;
/*created by Sudarshan on 19-09-17*/
public class StarMessage {
	protected StarMessageCode code;

	protected String message;

	protected String additionalCode;

	protected StarMessageType type;

	protected String dispType;

	public StarMessageCode getCode() {
		return code;
	}

	public void setCode(StarMessageCode code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StarMessageType getType() {
		return type;
	}

	public void setType(StarMessageType type) {
		this.type = type;
	}

	public String getAdditionalCode() {
		return additionalCode;
	}

	public void setAdditionalCode(String additionalCode) {
		this.additionalCode = additionalCode;
	}

	public StarMessage(StarMessageCode code, String message, StarMessageType type) {
		this.code = code;
		this.message = message;
		this.type = type;
	}

	public StarMessage(String code, String message, StarMessageType type) {
		this.additionalCode = code;
		this.message = message;
		this.type = type;
	}

	public StarMessage() {

	}

	public StarMessage type(StarMessageType type) {
		this.type = type;
		return this;
	}

	public StarMessage message(String message) {
		this.message = message;
		return this;
	}

	public StarMessage code(StarMessageCode code) {
		this.code = code;
		return this;
	}

	public StarMessage additionalCode(String additionalCode) {
		this.additionalCode = additionalCode;
		return this;
	}

	public String getDispType() {
		return dispType;
	}

	public void setDispType(String dispType) {
		this.dispType = dispType;
	}

	public StarMessage dispType(String dispType) {
		this.dispType = dispType;
		return this;
	}
}
