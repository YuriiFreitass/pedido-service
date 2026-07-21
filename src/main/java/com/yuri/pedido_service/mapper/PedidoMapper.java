package com.yuri.pedido_service.mapper;

import com.yuri.pedido_service.dto.PedidoRequestDto;
import com.yuri.pedido_service.dto.PedidoResponseDto;
import com.yuri.pedido_service.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
	PedidoEntity toEntity(PedidoRequestDto pedidoRequestDto);

	PedidoResponseDto toResponseDto(PedidoEntity pedidoEntity);

	void updateEntityFromDto(
			PedidoRequestDto pedidoRequestDto,
			@MappingTarget PedidoEntity pedidoEntity
	);
}
