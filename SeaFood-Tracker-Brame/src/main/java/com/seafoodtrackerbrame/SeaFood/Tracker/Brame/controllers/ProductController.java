package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.controllers;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.ProductModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services.ProductService;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bramestockmanager")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/productos")
    public ArrayList<ProductModel> getNombre(){
        return this.ProductService.getNombre();

    }

    @PostMapping("/productos")
    public ProductModel saveUser(@RequestBody ProductModel productos){
        return this.ProductService.saveUser(productos);
    }

    @GetMapping(path = "/productos/{id_producto}")
    public Optional<ProductModel> getUserById(@PathVariable("id_producto") Long id){
        return this.ProductService.getById(id);
    }

    @PutMapping(path = "/productos/{id_producto}")
    public ProductModel updateById(@RequestBody ProductModel request ,@PathVariable("id_producto") long id){
        return this.ProductService.updateById(request, id);

    }
    @DeleteMapping(path = "/productos/{id_producto}")
    public String deleteById(@PathVariable("id_producto") long id_producto){
        boolean ok = this.ProductService.deleteUser(id_producto);
        if (ok){
            return "El producto " + id_producto + " ha sido eliminado!";
        }else{
            return "Error, producto no encontrado";
        }
    }
}
