package com.company.vehicles.vehiculo.services;

import com.company.vehicles.vehiculo.repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.company.vehicles.models.Vehicle;
import com.company.vehicles.vehiculo.dto.OperationRensposeDto;
import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.dto.VehicleStockRequestDto;
import com.company.vehicles.vehiculo.entities.VehicleEntity;
import com.company.vehicles.vehiculo.mappers.VehicleMapper;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    
    public VehicleServiceImpl() {
  
    }

    @Override
    public List<VehicleResponseDto> getAllActiveVehicles() {
        List<VehicleEntity> todo = vehicleRepository.findByDeleted("N");
        List<VehicleResponseDto> respuesta = new ArrayList<>();
        for (VehicleEntity vehicle : todo) {
            if(vehicle.getPrice()> 200000 && vehicle.getStock()>10){
                respuesta.add(VehicleMapper.toResponse(vehicle));
            }
        }
        return respuesta;
    
    }
    @Override
    public List<VehicleResponseDto> getLowStockExpensiveVehicles() {
        List<VehicleEntity> todo = vehicleRepository.findByDeleted("N");
        List<VehicleResponseDto> respuesta = new ArrayList<>();
        for (VehicleEntity vehicle : todo) {
            if(vehicle.getPrice()> 200000 && vehicle.getStock()>10){
                respuesta.add(VehicleMapper.toResponse(vehicle));
            }
        }
        return respuesta;
    
    }
    
    @Override
    public OperationRensposeDto deleteByModel(String model) {
        Optional<VehicleEntity> vehicleOpt = vehicleRepository.findByModel(model);
        if (vehicleOpt.isPresent()) {
            VehicleEntity vehicle = vehicleOpt.get();
            vehicle.setDeleted("S");
            vehicleRepository.save(vehicle);
            return new OperationRensposeDto(true, "Vehículo eliminado exitosamente");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado");
    }

    @Override
    public VehicleResponseDto updateStock(VehicleStockRequestDto request) {
        Optional<VehicleEntity> vehicleOpt = vehicleRepository.findById(request.getId());
        if (vehicleOpt.isPresent()) {
            VehicleEntity vehicle = vehicleOpt.get();
            vehicle.setStock(request.getStock());
            VehicleEntity updated = vehicleRepository.save(vehicle);
            return VehicleMapper.toResponse(updated);
        }
        return null;
    }



}


