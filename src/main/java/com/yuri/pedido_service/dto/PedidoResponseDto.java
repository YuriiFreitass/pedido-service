package com.yuri.pedido_service.dto;

import com.yuri.pedido_service.enums.StatusPedido;

public record PedidoResponseDto(
		Long pedidoId,
		String descricao,
		double valorTotal,
		StatusPedido statusPedido
) {
}
