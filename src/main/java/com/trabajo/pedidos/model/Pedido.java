package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20)
    private LocalDate fechaDePedido;
    @Column(length = 20)
    private LocalDate fechaDeEnvio;
    @Column(length = 70)
    private String direccionEnvio;
    @Column(length = 50)
    private String CiudadEnvio;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private Transporte transporte;


}
