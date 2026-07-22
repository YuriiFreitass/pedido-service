package com.yuri.pedido_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ClienteClient {

	private final RestClient restClient;

	public ClienteClient(RestClient.Builder builder) {
		this.restClient = builder
				.baseUrl("http://localhost:8080")
				.build();
	}
	public ClienteResponseDto findById(Long clienteId) {
		return restClient.get()
				.uri("/v1/clientes/{id}", clienteId)
				.retrieve()
				.body(ClienteResponseDto.class);
	}


}
