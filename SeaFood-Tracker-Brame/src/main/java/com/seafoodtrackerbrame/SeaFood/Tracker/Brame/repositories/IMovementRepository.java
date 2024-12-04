package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovementRepository extends JpaRepository<MovementModel,Long>{
}
