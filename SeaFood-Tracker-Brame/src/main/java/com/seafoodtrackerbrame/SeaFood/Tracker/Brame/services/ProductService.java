package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.ProductModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.IProductRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;
    public ArrayList<ProductModel> getNombre(){
        return(ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel saveUser (ProductModel productos){
        return productRepository.save(productos);
    }

    public Optional<ProductModel> getById(Long id){
        return productRepository.findById(id);
    }

    public ProductModel updateById(ProductModel request, long id){
        ProductModel ProductModel = productRepository.findById(id).get();

        ProductModel.setNombre_producto(request.getNombre_producto());
        ProductModel.setDescripcion(request.getDescripcion());
        ProductModel.setPrecio(request.getPrecio());
        ProductModel.setStock(request.getStock());
        productRepository.save(ProductModel);
        return ProductModel;
    }

    public Boolean deleteUser (Long id){
        try{
            productRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

