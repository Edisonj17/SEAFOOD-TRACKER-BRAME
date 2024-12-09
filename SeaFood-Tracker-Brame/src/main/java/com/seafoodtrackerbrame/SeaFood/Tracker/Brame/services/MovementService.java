package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.services;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.MovementModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.ProductModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.UserModel;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.IMovementRepository;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.ProductRepository;
import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories.UserRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
    @Autowired
    IMovementRepository movementRepository;
    @Autowired
    private ProductRepository productRepository;  // Repositorio para Producto

    @Autowired
    private UserRepository userRepository;  // Repositorio para Usuario

    public ArrayList<MovementModel> getNombre(){
        return (ArrayList<MovementModel>) movementRepository.findAll();
    }

    public MovementModel saveUser(MovementModel movimientos){
        
        if (movimientos.getFecha_movimiento() == null) {
        movimientos.setFecha_movimiento(LocalDateTime.now());
        }
        
        // Obtener las entidades relacionadas desde la base de datos
        ProductModel producto = productRepository.findById(movimientos.getProducto().getId_producto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        UserModel usuario = userRepository.findById(movimientos.getUsuario().getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Asignar las entidades al movimiento
        movimientos.setProducto(producto);
        movimientos.setUsuario(usuario);

        // Guardar el movimiento con las entidades completas
        return movementRepository.save(movimientos);
        
         
        
    }
    
    public Optional<MovementModel> getById(Long id){
        return movementRepository.findById(id);
    }

    public MovementModel updateById(MovementModel request, long id) {
    // Buscar el movimiento existente por ID
    MovementModel MovementModel = movementRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado con ID: " + id));
    
    // Actualizar los campos del movimiento
    MovementModel.setCantidad(request.getCantidad());
    MovementModel.setTipo_movimiento(request.getTipo_movimiento());

    // Actualizar la fecha si est� presente en la solicitud
    if (request.getFecha_movimiento() != null) {
        MovementModel.setFecha_movimiento(request.getFecha_movimiento());
    }

    // Obtener las entidades relacionadas desde la base de datos
    ProductModel producto = productRepository.findById(request.getProducto().getId_producto())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + request.getProducto().getId_producto()));
    UserModel usuario = userRepository.findById(request.getUsuario().getId_usuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getUsuario().getId_usuario()));

    // Asignar las entidades actualizadas al movimiento
    MovementModel.setProducto(producto);
    MovementModel.setUsuario(usuario);

    // Guardar el movimiento actualizado
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
