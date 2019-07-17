package br.com.rtrancoso.spring.springboothandson.error.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

	private String message;
	private String[] errors;
	private LocalDateTime timestamp;

}
