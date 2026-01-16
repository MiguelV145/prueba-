package com.company.vehicles.vehiculo.services;

import java.util.List;


import com.company.vehicles.vehiculo.dto.OperationRensposeDto;
import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.dto.VehicleStockRequestDto;


public interface VehicleService {

List<VehicleResponseDto> getAllActiveVehicles();

    List<VehicleResponseDto> getLowStockExpensiveVehicles();
    
    OperationRensposeDto deleteByModel(String model);

    VehicleResponseDto updateStock(VehicleStockRequestDto request);

}
