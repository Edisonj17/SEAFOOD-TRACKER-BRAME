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
    
    @GetMapping("/bramestockmanager")
    public ArrayList<UserModel> getNombre(){
        return this.UserService.getNombre();
        
    }
    
    @PostMapping("/usubramestockmanagerarios")
    public UserModel saveUser(@RequestBody UserModel usuarios){
        return this.UserService.saveUser(usuarios);
    }
      
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){    
        return this.UserService.getById(id);    
    }
    
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") long id){
        return this.UserService.updateById(request, id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") long id){
        boolean ok = this.UserService.deleteUser(id);
        if (ok){
            return "El usuario" + id + "ha sido eliminado!";
        }else{
            return "Error, usuario no encontrado";
        }
    }
}
 