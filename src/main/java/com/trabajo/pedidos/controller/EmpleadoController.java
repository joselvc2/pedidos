package com.trabajo.pedidos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Empleado;
import com.trabajo.pedidos.repository.EmpleadoRepository;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	private final EmpleadoRepository empleadoRepository;

	public EmpleadoController(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	@GetMapping
    public List<Empleado> getEmpleados() {
		return (List<Empleado>) empleadoRepository.findAll();
    }

    @PostMapping
    void addEmpleados(@RequestBody Empleado empleado) {
    	empleadoRepository.save(empleado);
    }
	
    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable long id) {
		Optional<Empleado> empleado = empleadoRepository.findById(id);
		if(!empleado.isPresent()) {
			throw new ModelNotFoundException("id-" + id);
		}
        return empleado.get();
    }
    
    @DeleteMapping("/{id}")
	public void deleteEmpleado(@PathVariable("id") Long id) {
		empleadoRepository.deleteById(id);

	}
    
    @PutMapping
	public void updateEmpleado(@RequestBody Empleado empleado) {
		empleadoRepository.save(empleado);
	}
    
}
