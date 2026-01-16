package com.company.vehicles.vehiculo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.company.vehicles.vehiculo.dto.OperationRensposeDto;
import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.dto.VehicleStockRequestDto;
import com.company.vehicles.vehiculo.entities.VehicleEntity;
import com.company.vehicles.vehiculo.mappers.VehicleMapper;
import com.company.vehicles.vehiculo.repositories.VehicleRepository;


public interface VehicleService {

List<VehicleResponseDto> getAllActiveVehicles();

    List<VehicleResponseDto> getLowStockExpensiveVehicles();
    
    OperationRensposeDto deleteByModel(String model);

    VehicleResponseDto updateStock(VehicleStockRequestDto request);

}
