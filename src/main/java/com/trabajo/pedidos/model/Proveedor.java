package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String nombreEmpresa;

    @Column(length = 50)
    private String nombreContacto;

    @Column(length = 70)
    private String direccion;

    @Column(length = 20)
    private String ciudad;

    @Column(length = 9)
    private String telefono;


}
