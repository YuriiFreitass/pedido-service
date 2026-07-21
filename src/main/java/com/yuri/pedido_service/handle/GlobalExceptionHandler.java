package com.yuri.pedido_service.handle;

import com.yuri.pedido_service.dto.CampoErrorDto;
import com.yuri.pedido_service.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidtionException(MethodArgumentNotValidException exception) {
		List<CampoErrorDto> campos = exception
				.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(fieldError -> new CampoErrorDto(
						fieldError.getField(),
						fieldError.getDefaultMessage()
				)).toList();
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.BAD_REQUEST.value(), "Erro de validação", campos
		);
		return ResponseEntity.badRequest().body(erro);
	}
}
