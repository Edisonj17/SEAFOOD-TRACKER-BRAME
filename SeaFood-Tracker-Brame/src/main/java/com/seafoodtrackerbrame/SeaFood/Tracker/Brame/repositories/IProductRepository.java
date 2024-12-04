package com.seafoodtrackerbrame.SeaFood.Tracker.Brame.repositories;

import com.seafoodtrackerbrame.SeaFood.Tracker.Brame.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel,Long>{
}
