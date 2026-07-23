package com.yuri.pedido_service.controller;

import com.yuri.pedido_service.client.ClienteClient;
import com.yuri.pedido_service.client.ClienteResponseDto;
import com.yuri.pedido_service.dto.PedidoRequestDto;
import com.yuri.pedido_service.dto.PedidoResponseDto;
import com.yuri.pedido_service.enums.StatusPedido;
import com.yuri.pedido_service.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedidos", description = "Endpoints para gerenciamento de pedidos")
@RestController
@RequestMapping("/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoService pedidoService;

	private final ClienteClient clienteClient;

	@Operation(summary = "Listar pedidos")
	@ApiResponse(responseCode = "200", description = "Pedidos retornados com sucesso")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<PedidoResponseDto> findAll(Pageable pageable) {
		return pedidoService.findAll(pageable);
	}

	@Operation(summary = "Buscar pedidos por ID")
	@ApiResponse(responseCode = "200", description = "Pedido encontrado")
	@ApiResponse(responseCode = "404", description = "Pedido não encontrado")
	@GetMapping("/{pedidoId}")
	@ResponseStatus(HttpStatus.OK)
	public PedidoResponseDto findById(@PathVariable Long pedidoId) {
		return pedidoService.findById(pedidoId);
	}

	@Operation(summary = "Cadastrar pedidos")
	@ApiResponse(responseCode = "201", description = "Pedido cadastrado com sucesso")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoResponseDto save(@Valid @RequestBody PedidoRequestDto pedidoRequestDto) {
		return pedidoService.save(pedidoRequestDto);
	}

	@Operation(summary = "Atualizar pedidos")
	@ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso")
	@PutMapping("/{pedidoId}")
	@ResponseStatus(HttpStatus.OK)
	public PedidoResponseDto update(@PathVariable Long pedidoId, @Valid @RequestBody PedidoRequestDto pedidoRequestDto) {
		return pedidoService.update(pedidoId, pedidoRequestDto);
	}

	@PatchMapping("/{pedidoId}/status")
	public  PedidoResponseDto atualizarStatus(@PathVariable Long pedidoId, @RequestParam StatusPedido statusPedido) {
		return pedidoService.atualizarStatus(pedidoId, statusPedido);
	}

	@Operation(summary = "Excluir pedidos")
	@ApiResponse(responseCode = "204", description = "Pedido removido com sucesso")
	@DeleteMapping("/{pedidoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long pedidoId) {
		pedidoService.deleteById(pedidoId);
	}
}
