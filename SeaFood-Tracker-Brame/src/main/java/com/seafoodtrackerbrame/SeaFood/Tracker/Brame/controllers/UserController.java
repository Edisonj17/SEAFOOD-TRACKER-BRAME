/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.controllers;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.UserModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services.UserService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bramestockmanager")
public class UserController {
    
    @Autowired
    private UserService UserService;    
    
    @GetMapping("/usuarios")
    public ArrayList<UserModel> getNombre(){
        return this.UserService.getNombre();
        
    }
    
    @PostMapping("/usuarios")
    public UserModel saveUser(@RequestBody UserModel usuarios){
        return this.UserService.saveUser(usuarios); 
    }
      
    @GetMapping(path = "/usuarios/{id_usuario}")
    public Optional<UserModel> getUserById(@PathVariable("id_usuario") Long id){
        return this.UserService.getById(id);    
    }
    
    @PutMapping(path = "/usuarios/{id_usuario}")
    public UserModel updateById(@RequestBody UserModel request ,@PathVariable("id_usuario") long id){
        return this.UserService.updateById(request, id);

    }
    @DeleteMapping(path = "/usuarios/{id_usuario}")
    public String deleteById(@PathVariable("id_usuario") long id_usuario){
        boolean ok = this.UserService.deleteUser(id_usuario);
        if (ok){
            return "El usuario " + id_usuario + " ha sido eliminado!";
        }else{
            return "Error, usuario no encontrado";
        }
    }
}
 