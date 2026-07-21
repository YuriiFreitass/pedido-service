package com.yuri.pedido_service.controller;

import com.yuri.pedido_service.dto.PedidoRequestDto;
import com.yuri.pedido_service.dto.PedidoResponseDto;
import com.yuri.pedido_service.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoService pedidoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<PedidoResponseDto> findAll(Pageable pageable) {
		return pedidoService.findAll(pageable);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoResponseDto save(@Valid @RequestBody PedidoRequestDto pedidoRequestDto) {
		return pedidoService.save(pedidoRequestDto);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PedidoResponseDto findById(@PathVariable Long id) {
		return pedidoService.findById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PedidoResponseDto update(@PathVariable Long id, @Valid @RequestBody PedidoRequestDto pedidoRequestDto) {
		return pedidoService.update(id, pedidoRequestDto);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pedidoService.deleteById(id);
	}
}
