package com.yuri.pedido_service.client;

public record ClienteResponseDto(
		Long id,
		String nome,
		String email,
		String telefone
) {
}