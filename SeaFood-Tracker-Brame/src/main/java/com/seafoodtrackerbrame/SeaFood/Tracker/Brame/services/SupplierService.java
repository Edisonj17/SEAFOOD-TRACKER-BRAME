package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.SupplierModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.ISupplierRepository;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    ISupplierRepository supplierRepository;
    public ArrayList<SupplierModel> getNombre(){
        return(ArrayList<SupplierModel>) supplierRepository.findAll();
    }

    public SupplierModel saveUser (SupplierModel proveedores){
        return supplierRepository.save(proveedores);
    }

    public Optional<SupplierModel> getById(Long id){
        return supplierRepository.findById(id);
    }

    public SupplierModel updateById(SupplierModel request, long id){
        SupplierModel SupplierModel = supplierRepository.findById(id).get();

        SupplierModel.setNombre_proveedor(request.getNombre_proveedor());
        SupplierModel.setEmail_proveedor(request.getEmail_proveedor());
        SupplierModel.setTelefono_proveedor(request.getTelefono_proveedor());
        supplierRepository.save(SupplierModel);
        return SupplierModel;
    }

    public Boolean deleteUser (Long id){
        try{
            supplierRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
