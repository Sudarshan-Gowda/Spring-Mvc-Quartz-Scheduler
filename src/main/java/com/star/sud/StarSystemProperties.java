package com.star.sud;
/*@Author Sudarshan*/
import org.springframework.stereotype.Service;

@Service("starSystemProperties")
public class StarSystemProperties {

	protected String commonPath;

	protected String logfileLoc;

	protected String sessionTimeOut;

	public String getLogfileLoc() {
		return commonPath + logfileLoc;
	}

	public void setLogfileLoc(String logfileLoc) {
		this.logfileLoc = logfileLoc;
	}

	public String getCommonPath() {
		return commonPath;
	}

	public void setCommonPath(String commonPath) {
		this.commonPath = commonPath;
	}

	public String getSessionTimeOut() {
		return sessionTimeOut;
	}

	public void setSessionTimeOut(String sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}

}
