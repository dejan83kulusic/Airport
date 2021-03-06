package com.dejan.exception;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UserNotFoundException {

	  @ResponseBody
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String userNotFoundHandler(UserNotFoundException ex) {
	    return ex.toString();
	  }

	
}
