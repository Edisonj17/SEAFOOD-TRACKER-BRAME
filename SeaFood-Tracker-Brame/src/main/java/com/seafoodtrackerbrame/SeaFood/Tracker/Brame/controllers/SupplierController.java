package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.controllers;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services.SupplierService;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.SupplierModel;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bramestockmanager")
public class SupplierController {

    @Autowired
    private SupplierService SupplierService;

    @GetMapping("/proveedores")
    public ArrayList<SupplierModel> getNombre(){
        return this.SupplierService.getNombre();

    }

    @PostMapping("/proveedores")
    public SupplierModel saveUser(@RequestBody SupplierModel proveedores){
        return this.SupplierService.saveUser(proveedores);
    }

    @GetMapping(path = "/proveedores/{id_proveedor}")
    public Optional<SupplierModel> getUserById(@PathVariable("id_proveedor") Long id){
        return this.SupplierService.getById(id);
    }

    @PutMapping(path = "/proveedores/{id_proveedor}")
    public SupplierModel updateById(@RequestBody SupplierModel request ,@PathVariable("id_proveedor") long id){
        return this.SupplierService.updateById(request, id);

    }
    @DeleteMapping(path = "/proveedores/{id_proveedor}")
    public String deleteById(@PathVariable("id_proveedor") long id_proveedor){
        boolean ok = this.SupplierService.deleteUser(id_proveedor);
        if (ok){
            return "El proveedor " + id_proveedor + " ha sido eliminado!";
        }else{
            return "Error, proveedor no encontrado";
        }
    }
}
