package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.controllers;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.MovementModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services.MovementService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bramestockmanager")
public class MovementController {

    @Autowired
    private MovementService MovementService;

    @GetMapping("/movimientos")
    public ArrayList<MovementModel> getNombre(){
        return this.MovementService.getNombre();

    }

    @PostMapping("/movimientos")
    public MovementModel saveUser(@RequestBody MovementModel movimientos){
        return this.MovementService.saveUser(movimientos);
    }

    @GetMapping(path = "/movimientos/{id_movimiento}")
    public Optional<MovementModel> getUserById(@PathVariable("id_movimiento") Long id){
        return this.MovementService.getById(id);
    }

    @PutMapping(path = "/movimientos/{id_movimiento}")
    public MovementModel updateById(@RequestBody MovementModel request ,@PathVariable("id_movimiento") long id){
        return this.MovementService.updateById(request, id);

    }
    @DeleteMapping(path = "/movimientos/{id_movimiento}")
    public String deleteById(@PathVariable("id_movimiento") long id_movimiento){
        boolean ok = this.MovementService.deleteUser(id_movimiento);
        if (ok){
            return "El movimiento con la id " + id_movimiento + " ha sido eliminado!";
        }else{
            return "Error, movimiento no encontrado";
        }
    }
}
