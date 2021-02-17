package com.trabajo.pedidos.repository;

import com.trabajo.pedidos.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository <Producto,Long> {
}
