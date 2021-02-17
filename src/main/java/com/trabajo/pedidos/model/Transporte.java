package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String nombreEmpresa;
    @Column(length = 9)
    private String telefono;
}
