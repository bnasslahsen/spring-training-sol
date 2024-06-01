package com.example.springboothellorest;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author bnasslahsen
 */
@RestControllerAdvice
public class ExceptionTranslator  extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ProblemDetail handleNoSuchElementException(NoSuchElementException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail( HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setProperty("id", UUID.randomUUID().toString());
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setTitle("No Such Element Exception");
		return problemDetail;

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ProblemDetail handleException(Exception e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail( HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setProperty("id", UUID.randomUUID().toString());
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setTitle("No Such Element Exception");
		return problemDetail;
	}
}
