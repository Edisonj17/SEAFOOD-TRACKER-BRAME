/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    
}
