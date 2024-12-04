package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "proveedores")
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Crear las variables que va a guardar la BD

    private int id_proveedor;

    @Column(name = "nombre_proveedor", nullable = false)
    private String nombre_proveedor;

    @Column(name = "contacto_proveedor", nullable = false)
    private String contacto_proveedor;

    @Column(name = "telefono_proveedor", nullable = false)
    private String telefono_proveedor;

    @Column(name = "email_proveedor", nullable = false)
    private String email_proveedor;


    //Creación de los métodos GET.

    public int getId_proveedor() {
        return id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public String getContacto_proveedor() {
        return contacto_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }


    //Creación de los métodos Set.


    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public void setContacto_proveedor(String contacto_proveedor) {
        this.contacto_proveedor = contacto_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }
}
