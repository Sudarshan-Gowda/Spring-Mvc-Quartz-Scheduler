package com.star.sud.security;
/*@Author Sudarshan*/
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.star.sud.SectionKeys;
import com.star.sud.StarUtil;

public class StarSecurityAuthSucessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Map<String, String> reqParams = new HashMap<String, String>();

		@SuppressWarnings("unchecked")
		Enumeration<String> paramNameEnum = request.getParameterNames();

		while (paramNameEnum.hasMoreElements()) {
			String paramName = paramNameEnum.nextElement();

			if (!(paramName.equals("starMessage") || StringUtils.containsIgnoreCase(paramName, "USERNAME")
					|| StringUtils.containsIgnoreCase(paramName, "PASSWORD")))
				reqParams.put(paramName, request.getParameter(paramName));
		}

		String paramStr = StarUtil.getParamsAsString(reqParams);
		String finalUrl = request.getContextPath() + "/" + SectionKeys.WELCOME;

		if (!paramStr.isEmpty()) {
			finalUrl += "?" + paramStr;

		}
		response.sendRedirect(finalUrl);
	}

}
