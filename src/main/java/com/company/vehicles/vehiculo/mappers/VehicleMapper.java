package com.company.vehicles.vehiculo.mappers;

import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.entities.VehicleEntity;

public class VehicleMapper {

    public static VehicleResponseDto toResponse(VehicleEntity vehicle) {
        if (vehicle == null) {
            return null;
        }
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setPrice(vehicle.getPrice());
        dto.setStock(vehicle.getStock());
        return dto;
    }
}
