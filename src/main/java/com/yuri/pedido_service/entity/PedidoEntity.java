package com.yuri.pedido_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int numeroPedido;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private double valorTotal;

}
