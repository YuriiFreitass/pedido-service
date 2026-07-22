package com.yuri.pedido_service.service;


import com.yuri.pedido_service.dto.PedidoRequestDto;
import com.yuri.pedido_service.dto.PedidoResponseDto;
import com.yuri.pedido_service.entity.PedidoEntity;
import com.yuri.pedido_service.exception.PedidoNaoEncontradoException;
import com.yuri.pedido_service.mapper.PedidoMapper;
import com.yuri.pedido_service.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final PedidoMapper pedidoMapper;

	public Page<PedidoResponseDto> findAll(Pageable pageable) {
		return pedidoRepository.findAll(pageable).map(pedidoMapper::toResponseDto);
	}

	public PedidoResponseDto findById(Long pedidoId) {
		PedidoEntity pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado"));
		return pedidoMapper.toResponseDto(pedido);

	}

	public PedidoResponseDto save(PedidoRequestDto pedidoRequestDto) {

		PedidoEntity pedido = pedidoMapper.toEntity(pedidoRequestDto);

		PedidoEntity pedidoSalvo = pedidoRepository.save(pedido);

		return pedidoMapper.toResponseDto(pedidoSalvo);
	}

	public PedidoResponseDto update(Long pedidoId, PedidoRequestDto pedidoRequestDto) {
		PedidoEntity pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradoException("O pedido não foi encontrado"));

		pedidoMapper.updateEntityFromDto(pedidoRequestDto, pedido);

		PedidoEntity pedidoSalvo = pedidoRepository.save(pedido);

		return pedidoMapper.toResponseDto(pedidoSalvo);
	}

	public void deleteById(Long pedidoId) {
		PedidoEntity pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradoException("O pedido com ID" + pedidoId + " não foi encontrado"));
		pedidoRepository.delete(pedido);
	}



}
