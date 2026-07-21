package com.yuri.pedido_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequestDto(
		@NotBlank String descricao,
		@NotNull @Positive double valorTotal
) {}
