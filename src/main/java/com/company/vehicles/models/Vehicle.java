package com.company.vehicles.models;

import com.company.vehicles.vehiculo.entities.VehicleEntity;

public class Vehicle {

    public static Vehicle froEntity(VehicleEntity entity){
        return new Vehicle(entity.getId())
    }
    
}
