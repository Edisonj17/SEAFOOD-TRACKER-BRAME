/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.UserModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.IUserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired  
    IUserRepository userRepository;   
    public ArrayList<UserModel> getNombre(){
        return(ArrayList<UserModel>) userRepository.findAll();
    }
    
    public UserModel saveUser (UserModel usuarios){
        return userRepository.save(usuarios);
    }
    
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }
    
    public UserModel updateById(UserModel request, long id){
        UserModel UserModel = userRepository.findById(id).get();
                
        UserModel.setNombre(request.getNombre());
        UserModel.setContrasena(request.getContrasena());
        UserModel.setRol(request.getRol());
        userRepository.save(UserModel);
        return UserModel;
    }
    
    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
