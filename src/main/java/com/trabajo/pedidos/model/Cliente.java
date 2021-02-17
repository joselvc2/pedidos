package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(length = 50)
    private String nombreEmpresa;
    @Column(length = 50)
    private String nombreContacto;
    @Column(length = 70)
    private String direccion;
    @Column(length = 50)
    private String ciudad;
    @Column(length = 9)
    private String telefono;


}
