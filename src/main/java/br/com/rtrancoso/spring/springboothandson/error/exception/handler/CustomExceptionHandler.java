package br.com.rtrancoso.spring.springboothandson.error.exception.handler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.rtrancoso.spring.springboothandson.error.exception.BusinessException;
import br.com.rtrancoso.spring.springboothandson.error.model.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler( EntityNotFoundException.class )
	public ResponseEntity<ErrorResponse> notFound( Exception ex, WebRequest request ) throws IOException {
		return createErrorResponse( HttpStatus.NOT_FOUND, ex.getMessage() );
	}

	@ExceptionHandler( ConstraintViolationException.class )
	public ResponseEntity<ErrorResponse> constraint( ConstraintViolationException ex, WebRequest request ) throws IOException {
		var list = new ArrayList<String>();
		ex.getConstraintViolations().stream().forEach( e -> {
			list.add( e.getMessage() );
		} );
		return createErrorResponse( HttpStatus.BAD_REQUEST, list.toArray( new String[list.size()] ) );
	}

	@ExceptionHandler( BusinessException.class )
	public ResponseEntity<ErrorResponse> business( Exception ex, WebRequest request ) throws IOException {
		return createErrorResponse( HttpStatus.BAD_REQUEST, ex.getMessage() );
	}

	private ResponseEntity<ErrorResponse> createErrorResponse( HttpStatus httpStatus, String errorMessage ) {
		return createErrorResponse( httpStatus, errorMessage, null );
	}

	private ResponseEntity<ErrorResponse> createErrorResponse( HttpStatus httpStatus, String[] errorMessages ) {
		return createErrorResponse( httpStatus, null, errorMessages );
	}

	private ResponseEntity<ErrorResponse> createErrorResponse( HttpStatus httpStatus, String message, String[] errors ) {
		return new ResponseEntity<>( ErrorResponse.builder().message( message ).errors( errors ).timestamp( LocalDateTime.now() ).build(), httpStatus );
	}
}
