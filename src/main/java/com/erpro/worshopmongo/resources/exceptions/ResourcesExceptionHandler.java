package com.erpro.worshopmongo.resources.exceptions;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.erpro.worshopmongo.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException object, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(System.currentTimeMillis(), status.value(), "ERRO NÃO ENCONTRADO",
				object.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
