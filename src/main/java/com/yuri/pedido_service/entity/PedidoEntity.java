package com.yuri.pedido_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private int numeroPedido;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private double valorTotal;

}
