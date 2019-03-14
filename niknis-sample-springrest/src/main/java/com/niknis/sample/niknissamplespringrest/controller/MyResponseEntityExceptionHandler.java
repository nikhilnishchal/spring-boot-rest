package com.niknis.sample.niknissamplespringrest.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.niknis.sample.niknissamplespringrest.exception.ExceptionResponse;
import com.niknis.sample.niknissamplespringrest.exception.StudentNotFoundException;

@ControllerAdvice //shared b/w multiple controller class
@RestController
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr){
		
		ExceptionResponse exRes = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity(exRes, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(Exception ex, WebRequest wr){
		
		ExceptionResponse exRes = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity(exRes, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionResponse exRes = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exRes, HttpStatus.BAD_REQUEST);
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
}
