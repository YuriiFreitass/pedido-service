package com.yuri.pedido_service.dto;

import java.util.List;

public record ErrorResponseDto(
		int status,
		String mensagem,
		List<CampoErrorDto> campos
) {}
