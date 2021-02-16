package com.trabajo.pedidos.repository;

import com.trabajo.pedidos.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository <Categoria, Long> {
}
