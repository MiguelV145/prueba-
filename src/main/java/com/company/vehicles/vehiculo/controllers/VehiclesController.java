package com.company.vehicles.vehiculo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.vehicles.vehiculo.dto.OperationRensposeDto;
import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.dto.VehicleStockRequestDto;
import com.company.vehicles.vehiculo.services.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> getActiveVehicles() {
        List<VehicleResponseDto> vehicles = vehicleService.getAllActiveVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/low-stock-expensive")
    public ResponseEntity<List<VehicleResponseDto>> getLowStockExpensive() {
        List<VehicleResponseDto> vehicles = vehicleService.getLowStockExpensiveVehicles();
        return ResponseEntity.ok(vehicles);
    }

@PatchMapping("/delete/{model}")
    public ResponseEntity<OperationRensposeDto> deleteByModel(@PathVariable String model) {
        OperationRensposeDto response = vehicleService.deleteByModel(model);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        if (response.isConflict()) {    
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PatchMapping("/stock")
    public ResponseEntity<VehicleResponseDto> updateStock(@RequestBody VehicleStockRequestDto request) {
        VehicleResponseDto updated = vehicleService.updateStock(request);
        return  ResponseEntity.ok(updated);
    }
}
