package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Crear las variables que va a guardar la BD

    private int id_producto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombre_producto;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "stock", nullable = false)
    private int stock;

    @OneToMany(mappedBy = "producto")
    private List<MovementModel> movimientos = new ArrayList<>();

    //Creación de los métodos GET.

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public List<MovementModel> getMovimientos() {
        return movimientos;
    }

    //Creación de los métodos SET

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMovimientos(List<MovementModel> movimientos) {
        this.movimientos = movimientos;
    }
}