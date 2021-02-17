package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Pedido;

import com.trabajo.pedidos.repository.PedidoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidoController {
    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public List<Pedido> getPedidos() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @PostMapping
    void addPedidos(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(!pedido.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return pedido.get();
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable("id") Long id) {
        pedidoRepository.deleteById(id);

    }

    @PutMapping
    public void updatePedido(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
    }


}
