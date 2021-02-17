package com.trabajo.pedidos.repository;

import com.trabajo.pedidos.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository <Cliente, Long> {
}
