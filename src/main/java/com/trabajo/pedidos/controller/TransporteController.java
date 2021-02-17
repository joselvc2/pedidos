package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;

import com.trabajo.pedidos.model.Transporte;

import com.trabajo.pedidos.repository.TransporteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transportes")
@CrossOrigin
public class TransporteController {

    private final TransporteRepository transporteRepository;

    public TransporteController(TransporteRepository transporteRepository) {
        this.transporteRepository = transporteRepository;
    }

    @GetMapping
    public List<Transporte> getTransportes() {
        return (List<Transporte>) transporteRepository.findAll();
    }

    @PostMapping
    void addTransportes(@RequestBody Transporte transporte) {
        transporteRepository.save(transporte);
    }

    @GetMapping("/{id}")
    public Transporte getTransporte(@PathVariable long id) {
        Optional<Transporte> transporte = transporteRepository.findById(id);
        if(!transporte.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return transporte.get();
    }

    @DeleteMapping("/{id}")
    public void deleteTransporte(@PathVariable("id") Long id) {
        transporteRepository.deleteById(id);

    }

    @PutMapping
    public void updateTransporte(@RequestBody Transporte transporte) {
        transporteRepository.save(transporte);
    }

}
