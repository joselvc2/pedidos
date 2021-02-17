package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 10)
    private double precioUnitario;
    @Column(length = 15)
    private int cantidad;

    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Producto producto;

}
