package com.calculadora.handle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.calculadora.dtos.MensajeError;
import com.calculadora.exceptions.OperationNotSupportException;

@ControllerAdvice
public class CalculadoraHandleException {

	@ExceptionHandler(OperationNotSupportException.class)
	public ResponseEntity<MensajeError> OperationNotSupportException(OperationNotSupportException e) {
		
		MensajeError error = new MensajeError();
	
		error.setMensaje(e.getMessage());
		
		return new ResponseEntity<MensajeError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
