package com.yuri.pedido_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequestDto(
		@NotNull Long clienteId,
		@NotBlank String descricao,
		@Positive double valorTotal
) {}
