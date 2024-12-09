package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
public class MovementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Variables a guardar

    private int id_movimiento;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipo_movimiento", nullable = false)
    private String tipo_movimiento;

    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDateTime fecha_movimiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonProperty
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonProperty
    private ProductModel producto;
//Métodos Get


    public int getId_movimiento() {
        return id_movimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public LocalDateTime getFecha_movimiento() {
        return fecha_movimiento;
    }

//Métodos SET


    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public void setProducto(ProductModel producto) {
        this.producto = producto;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public void setFecha_movimiento(LocalDateTime fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public ProductModel getProducto() {
        return producto;
    }   
    

}

