package com.yuri.pedido_service.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
	public PedidoNaoEncontradoException(String message) {
		super(message);
	}
}
