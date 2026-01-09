package com.company.vehicles.vehiculo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.company.vehicles.vehiculo.entities.VehicleEntity;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    List<VehicleEntity> findByDeleted(String deleted);

    List<VehicleEntity> findByDeletedAndPriceGreaterThanAndStockLessThan(String deleted, Double price, Integer stock);

    Optional<VehicleEntity> findByModel(String model);
}
