package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Cliente;

import com.trabajo.pedidos.repository.ClienteRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @PostMapping
    void addClientes(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(!cliente.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return cliente.get();
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);

    }

    @PutMapping
    public void updateCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

}
