package com.apartment.apartmentPortal.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

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

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	  e.printStackTrace();
	  return new ResponseEntity<>("Something went wrong.",HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Exception ex) {
	  if (ex.getCause() instanceof RollbackException) {
	       RollbackException rollbackException = (RollbackException) ex.getCause();
	  if (rollbackException.getCause() instanceof ConstraintViolationException) {
          ConstraintViolationException jdbcEx = (ConstraintViolationException) rollbackException.getCause();
          final List<String> errors = new ArrayList<String>();
          for (final ConstraintViolation<?> violation : jdbcEx.getConstraintViolations()) {
              errors.add(violation.getPropertyPath() + ": " + violation.getMessage());
          }
          CustomException customException = new CustomException(jdbcEx.getMessage(),HttpStatus.BAD_REQUEST,errors);
           return new ResponseEntity<CustomException>(customException , customException.getHttpStatus());
	  	}
	  }
	  ex.printStackTrace();
	  return new ResponseEntity<String>("Something went wrong.",HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
