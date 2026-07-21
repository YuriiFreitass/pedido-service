package com.yuri.pedido_service.repository;

import com.yuri.pedido_service.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {


	Optional<PedidoEntity> findByNumeroPedido(int numeroPedido);

	boolean existsByNumeroPedido(int numeroPedido);

}
