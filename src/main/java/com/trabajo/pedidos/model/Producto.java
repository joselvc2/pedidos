package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 70)
    private String nombreProducto;
    @Column(length = 10)
    private double precioUnitario;
    private int unidadesEnStock;

    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_producto_categoria_id"), name="categoria_id", referencedColumnName = "id", columnDefinition = "long")
    @ManyToOne
    private Categoria categoria;
    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_producto_proveedor_id"), name="proveedor_id", referencedColumnName = "id", columnDefinition = "long")
    @ManyToOne
    private Proveedor proveedor;






}
