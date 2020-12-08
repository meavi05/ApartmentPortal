/**
 * 
 */
package com.apartment.apartmentPortal.exception;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author avi08
 *
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1789750144650834228L;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		CustomException exception = new CustomException(HttpStatus.FORBIDDEN, "User is Invalid.",
				"User is not authenticated.");

		try {
			//Needed JSON converter
			String json = mapper.writeValueAsString(exception);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
			response.getWriter().write(json);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
