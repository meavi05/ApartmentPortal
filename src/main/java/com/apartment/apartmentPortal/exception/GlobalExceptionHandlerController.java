package com.apartment.apartmentPortal.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

	 
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<CustomException> handleCustomException(CustomException ex) throws IOException {
	  return new ResponseEntity<CustomException>(ex,ex.getHttpStatus());
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<String> handleAccessDeniedException() throws IOException {
	  return new ResponseEntity<String>("Access Denied",HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException() {
	  return new ResponseEntity<>("Something went wrong.",HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
