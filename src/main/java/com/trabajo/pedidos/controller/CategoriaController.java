package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Categoria;
import com.trabajo.pedidos.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> getCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @PostMapping
    void addCategorias(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @GetMapping("/{id}")
    public Categoria getCategoria(@PathVariable long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(!categoria.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return categoria.get();
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable("id") Long id) {
        categoriaRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public void updateCategoria(@RequestBody Categoria categoria, @PathVariable("id") Long id) {
        categoria.setId(id);
        categoriaRepository.save(categoria);
    }

}
