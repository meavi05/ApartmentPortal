package com.application.exception;

import org.springframework.http.HttpStatus;

public class ReportableException {
	
	private HttpStatus status;
	private String error;
	private String description;
	
	public ReportableException(HttpStatus status, String error, String description) {
		super();
		this.status = status;
		this.error = error;
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CustomException [status=" + status + ", error=" + error + ", description=" + description + "]";
	}	

}
