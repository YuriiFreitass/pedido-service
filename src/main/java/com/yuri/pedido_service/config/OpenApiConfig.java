package com.yuri.pedido_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {

		return new OpenAPI()
				.info(new Info()
						.title("Microsserviço para gerenciamento de pedidos")
						.version("1.0.0")
						.description("API responsável pelo gerenciamento de pedidos e integração com o microserviço de clientes.")
						.contact(new Contact()
								.name("Yuri Freitas")
								.url("https://github.com/YuriiFreitass")
						)


				);
	}
}
