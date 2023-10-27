package dev.samarth.productService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.samarth.productService.dto.ErrorResponseDTO;
import dev.samarth.productService.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ExceptionAdvices {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleException(ProductNotFoundException exception) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setErrorMessage(exception.getMessage());
		
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
	}

}
