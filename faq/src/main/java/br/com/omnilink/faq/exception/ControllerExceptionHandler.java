package br.com.omnilink.faq.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerExceptionHandler {

//	@ExceptionHandler(value = NotFoundException.class)
//	public ResponseEntity<ErrorMessage> notFoundException (NotFoundException notFoundException, WebRequest request){
//		ErrorMessage errorMessage = new ErrorMessage(
//				HttpStatus.NOT_FOUND.value(), 
//				new Date(), 
//				notFoundException.getMessage(), 
//				request.getDescription(false));
//		return new ResponseEntity<ErrorMessage> (errorMessage, HttpStatus.NOT_FOUND);
//	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorMessage> genericExceptionHandler(Exception exception, WebRequest request){
//		ErrorMessage errorMessage = new ErrorMessage(
//				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
//				new Date(), 
//				exception.getMessage(), 
//				request.getDescription(false));
//		return new ResponseEntity<ErrorMessage> (errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
