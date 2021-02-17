package com.trabajo.pedidos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Empleado;
import com.trabajo.pedidos.repository.EmpleadoRepository;

@RestController
@RequestMapping("/empleados")
@CrossOrigin
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
