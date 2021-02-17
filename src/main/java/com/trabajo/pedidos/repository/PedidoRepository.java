package com.trabajo.pedidos.repository;

import com.trabajo.pedidos.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido,Long> {
}
