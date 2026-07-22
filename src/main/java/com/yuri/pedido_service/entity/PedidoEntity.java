package com.yuri.pedido_service.entity;

import com.yuri.pedido_service.enums.StatusPedido;
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

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private double valorTotal;

//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false)
//	private StatusPedido statusPedido;

	@Column(name = "cliente_id", nullable = false)
	private Long clienteId;
}
