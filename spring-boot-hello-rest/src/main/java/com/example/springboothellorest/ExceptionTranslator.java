package com.example.springboothellorest;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author bnasslahsen
 */
@RestControllerAdvice
public class ExceptionTranslator {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionTranslator.class);

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorDetail> handleNoSuchElementException(NoSuchElementException e) {
		ErrorDetail errorDetail = ErrorDetail.builder()
				.id(UUID.randomUUID().toString())
				.message(e.getMessage()).build();
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleException(Exception e) {
		ErrorDetail errorDetail = ErrorDetail.builder()
				.id(UUID.randomUUID().toString())
				.message("Erreur technique").build();
		LOGGER.error(errorDetail.getId(), e);
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}
}
