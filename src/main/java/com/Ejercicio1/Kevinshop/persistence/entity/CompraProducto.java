package com.Ejercicio1.Kevinshop.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="compras_productos")

public class CompraProducto {

    @EmbeddedId
    private CompraProductoPk id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Compra compras;

    @ManyToOne
    @JoinColumn(name="id_producto" , insertable = false , updatable = false)
    private Producto productos;

    public CompraProductoPk getId() {
        return id;
    }

    public void setId(CompraProductoPk id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
