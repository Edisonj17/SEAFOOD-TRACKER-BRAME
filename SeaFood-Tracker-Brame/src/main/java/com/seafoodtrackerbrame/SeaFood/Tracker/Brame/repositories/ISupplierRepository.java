package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends JpaRepository<SupplierModel,Long>{
}
