package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Proveedor;
import com.trabajo.pedidos.repository.ProveedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin
public class ProveedorController {

    private final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping
    public List<Proveedor> getProveedores() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    @PostMapping
    void addProveedores(@RequestBody Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedor(@PathVariable long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if(!proveedor.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return proveedor.get();
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable("id") Long id) {
        proveedorRepository.deleteById(id);

    }

    @PutMapping
    public void updateProveedor(@RequestBody Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

}


