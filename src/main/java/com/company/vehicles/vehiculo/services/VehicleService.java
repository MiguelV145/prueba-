package com.company.vehicles.vehiculo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.dto.VehicleStockRequestDto;
import com.company.vehicles.vehiculo.entities.VehicleEntity;
import com.company.vehicles.vehiculo.mappers.VehicleMapper;
import com.company.vehicles.vehiculo.repositories.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleResponseDto> getActiveVehicles() {
        List<VehicleEntity> activeVehicles = vehicleRepository.findByDeleted("N");
        return toDtoList(activeVehicles);
    }

    public List<VehicleResponseDto> getLowStockExpensive() {
        List<VehicleEntity> filtered = vehicleRepository
                .findByDeletedAndPriceGreaterThanAndStockLessThan("N", 20000.0, 10);
        return toDtoList(filtered);
    }

    public VehicleResponseDto logicalDeleteByModel(String model) {
        VehicleEntity vehicle = vehicleRepository.findByModel(model)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));

        if ("S".equalsIgnoreCase(vehicle.getDeleted())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Vehicle already deleted");
        }

        vehicle.setDeleted("S");
        VehicleEntity saved = vehicleRepository.save(vehicle);
        return VehicleMapper.toResponse(saved);
    }

    public VehicleResponseDto updateStock(VehicleStockRequestDto request) {
        VehicleEntity vehicle = vehicleRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));

        vehicle.setStock(request.getStock());
        VehicleEntity saved = vehicleRepository.save(vehicle);
        return VehicleMapper.toResponse(saved);
    }

    private List<VehicleResponseDto> toDtoList(List<VehicleEntity> vehicles) {
        return vehicles.stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }
}
