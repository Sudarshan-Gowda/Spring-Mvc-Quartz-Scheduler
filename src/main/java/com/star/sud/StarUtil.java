package com.star.sud;
/*@Author Sudarshan*/
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class StarUtil {

	public static String getParamsAsString(Map<String, String> reqParams) {
		StringBuffer paramsAsStr = new StringBuffer("");

		if (reqParams != null && reqParams.size() > 0) {
			for (String key : reqParams.keySet()) {
				if (!paramsAsStr.toString().isEmpty()) {
					paramsAsStr.append("&");
				}
				paramsAsStr.append(key + "=" + reqParams.get(key));
			}
		}

		return paramsAsStr.toString();
	}

	public static String getClientIPAddress(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}
		if (ipAddress.contains(",")) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}
		return ipAddress;
	}
}
