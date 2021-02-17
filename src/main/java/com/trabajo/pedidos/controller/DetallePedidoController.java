package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.DetallePedido;

import com.trabajo.pedidos.repository.DetallePedidoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-pedidos")
@CrossOrigin
public class DetallePedidoController {

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoController(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @GetMapping
    public List<DetallePedido> getDetallePedidos() {
        return (List<DetallePedido>) detallePedidoRepository.findAll();
    }

    @PostMapping
    void addDetallePedidos(@RequestBody DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
    }

    @GetMapping("/{id}")
    public DetallePedido getDetallePedido(@PathVariable long id) {
        Optional<DetallePedido> detallePedido = detallePedidoRepository.findById(id);
        if(!detallePedido.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return detallePedido.get();
    }

    @DeleteMapping("/{id}")
    public void deleteDetallePedido(@PathVariable("id") Long id) {
        detallePedidoRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public void updateDetallePedido(@RequestBody DetallePedido detallePedido,@PathVariable("id") Long id) {
        detallePedido.setId(id);
        detallePedidoRepository.save(detallePedido);
    }

}
