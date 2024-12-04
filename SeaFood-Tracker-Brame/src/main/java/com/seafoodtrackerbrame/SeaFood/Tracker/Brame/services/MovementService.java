package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.MovementModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.IMovementRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
    @Autowired
    IMovementRepository movementRepository;
    public ArrayList<MovementModel> getNombre(){
        return(ArrayList<MovementModel>) movementRepository.findAll();
    }

    public MovementModel saveUser (MovementModel movimientos){
        return movementRepository.save(movimientos);
    }

    public Optional<MovementModel> getById(Long id){
        return movementRepository.findById(id);
    }

    public MovementModel updateById(MovementModel request, long id){
        MovementModel MovementModel = movementRepository.findById(id).get();

        MovementModel.setCantidad(request.getCantidad());
        MovementModel.setTipo_movimiento(request.getTipo_movimiento());
        MovementModel.setFecha_movimiento(request.getFecha_movimiento());
        movementRepository.save(MovementModel);
        return MovementModel;
    }

    public Boolean deleteUser (Long id){
        try{
            movementRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
