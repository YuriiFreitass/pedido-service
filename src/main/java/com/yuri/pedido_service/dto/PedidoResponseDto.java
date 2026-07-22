package com.yuri.pedido_service.dto;

public record PedidoResponseDto(
		Long pedidoId,
		String descricao,
		double valorTotal
) {
}
