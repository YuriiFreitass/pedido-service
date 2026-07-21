package com.yuri.pedido_service.dto;

import jakarta.validation.constraints.NotNull;

public record PedidoRequestDto(
		@NotNull int numeroPedido
) {}
