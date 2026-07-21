package com.yuri.pedido_service.dto;

public record PedidoResponseDto(
		Long id,
		int numeroPedido,
		String descricao,
		double valorTotal
) {
}
