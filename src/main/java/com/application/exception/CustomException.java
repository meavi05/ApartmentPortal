package com.application.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String message;
  private final HttpStatus httpStatus;
  private List<String> errors = new ArrayList<String>();

  public CustomException(String message, HttpStatus httpStatus) {
	this.message = message;
    this.httpStatus = httpStatus;
  }
  
  public CustomException(String message, HttpStatus httpStatus,List<String>errors) {
		this.message = message;
	    this.httpStatus = httpStatus;
	    this.errors = errors;
	  }

  public String getMessage() {
    return message;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public List<String> getErrors() {
	return errors;
  }

@Override
public String toString() {
	return "CustomException [message=" + message + ", httpStatus=" + httpStatus + ", errors=" + errors + "]";
}

}
