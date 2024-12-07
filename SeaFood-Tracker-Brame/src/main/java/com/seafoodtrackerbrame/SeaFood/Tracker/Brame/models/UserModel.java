/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Crear las variables que va a guardar la BD 

    private int id_usuario;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    
    @Column(name = "rol", nullable = false)
    private String rol;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<MovementModel> movimientos = new ArrayList<>();
    
    //Creación de los métodos GET.

    public int getId_usuario() {
        return id_usuario;
    }        
    
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setMovimientos(List<MovementModel> movimientos) {
        this.movimientos = movimientos;
    }

    //Creación de los métodos Set.

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<MovementModel> getMovimientos() {
        return movimientos;
    }
}
