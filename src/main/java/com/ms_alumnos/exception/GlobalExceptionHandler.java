package com.ms_alumnos.exception;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ms_alumnos.request.ApiErrores;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("Verbo HTTP no soportado");
		
		ApiErrores error = new ApiErrores(mensaje, detalles, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("Tipo de dato no soportado");
		ApiErrores error = new ApiErrores(mensaje, detalles, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("NO se permite la sobreescritura");
		ApiErrores error = new ApiErrores(mensaje, detalles, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> NoSePuedeEditarException(NoSePuedeEditarException ex) {
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("NO se permite la sobreescritura");
		ApiErrores error = new ApiErrores(mensaje, detalles, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
